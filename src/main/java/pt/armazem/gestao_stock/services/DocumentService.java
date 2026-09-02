package pt.armazem.gestao_stock.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Document;
import pt.armazem.gestao_stock.domain.entities.DocumentItem;
import pt.armazem.gestao_stock.domain.entities.DocumentType;
import pt.armazem.gestao_stock.domain.entities.Item;
import pt.armazem.gestao_stock.domain.enums.OperationType;
import pt.armazem.gestao_stock.dtos.DocumentItemRequest;
import pt.armazem.gestao_stock.dtos.DocumentRequest;
import pt.armazem.gestao_stock.repositories.DocumentRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentCounterService documentCounterService;
    private final DocumentTypeService documentTypeService;
    private final WarehouseService warehouseService;
    private final ServiceAreaService serviceAreaService;
    private final ItemService itemService;
    private final WarehouseStockService warehouseStockService;

    @Transactional(readOnly = true)
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Document not found with ID: " + id));
    }
    @Transactional(readOnly = true)
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Transactional
    public Document createDocument(DocumentRequest dr) {

        if (dr.documentDate() == null) {
            throw new IllegalArgumentException("The document date must not be null.");
        }

        if (dr.items() == null || dr.items().isEmpty()) {
            throw new IllegalArgumentException("The document must have atleast one item.");
        }

        DocumentType dt = documentTypeService.getDocumentTypeById(dr.documentTypeId());
        OperationType ot = dt.getOperationType();
        int year = dr.documentDate().getYear();

        Long sn = documentCounterService.incrementDocCounter(ot, year);
        String idc = String.format("%s-%d/%d", ot.getPrefix(), year, sn);

        Document doc = new Document();
        doc.setDocumentType(dt); 
        doc.setOperationType(ot);
        doc.setYear(year);
        doc.setSequenceNumber(sn);
        doc.setInternalDocumentNumber(idc);
        doc.setOriginDocumentNumber(dr.originDocumentNumber());
        doc.setDocumentDate(dr.documentDate());
        doc.setObservations(dr.observations());

        if (dr.originWarehouseId() != null) {
            doc.setOriginWarehouse(warehouseService.getWarehouseById(dr.originWarehouseId()));
        }
        if (dr.originServiceAreaId() != null) {
            doc.setOriginServiceArea(serviceAreaService.getServiceAreaById(dr.originServiceAreaId()));
        }
        if (dr.destinationWarehouseId() != null) {
            doc.setDestinationWarehouse(warehouseService.getWarehouseById(dr.destinationWarehouseId()));
        }
        if (dr.destinationServiceAreaId() != null) {
            doc.setDestinationServiceArea(serviceAreaService.getServiceAreaById(dr.destinationServiceAreaId()));
        }

        populateDocument(doc, dr.items());
        return documentRepository.save(doc);
    }

    @Transactional
    public Document populateDocument(Document doc, List<DocumentItemRequest> dir) {
        for (DocumentItemRequest request : dir) {
            if (request.itemId() == null || request.quantity() == null) {
                throw new IllegalArgumentException("Item id and quantity must not be null.");
            }
            if (request.quantity().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero.");
            }

            Item item = itemService.getItemById(request.itemId());

            BigDecimal unitPrice = request.unitPriceExclVat() != null ? request.unitPriceExclVat() : item.getLastPriceNoVat();
            if (unitPrice == null) {
                throw new IllegalArgumentException("Unit price for " + item.getName() + " is required.");
            }

            BigDecimal vatRate = request.vatRate() != null ? request.vatRate() : item.getStandardVatRate();
            if (vatRate == null) {
                throw new IllegalArgumentException("Vat rate for " + item.getName() + " is required.");
            }

            BigDecimal totalExclVat = unitPrice.multiply(request.quantity());
            BigDecimal totalVat = totalExclVat.multiply(vatRate).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            BigDecimal totalInclVat = totalExclVat.add(totalVat);
            BigDecimal unitPriceInclVat = unitPrice.add(unitPrice.multiply(vatRate).divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP));

            DocumentItem line = new DocumentItem();
            line.setDocument(doc);
            line.setItem(item);
            line.setQuantity(request.quantity());
            line.setUnitPriceExclVat(unitPrice);
            line.setVatRate(vatRate);
            line.setUnitPriceInclVat(unitPriceInclVat);
            line.setTotalLineExclVat(totalExclVat);
            line.setTotalLineVat(totalVat);
            line.setTotalLineInclVat(totalInclVat);

            doc.getItems().add(line);

            if (doc.getDocumentType().getStockMovementEnabled()) {
                if (doc.getOriginWarehouse() != null) {
                    warehouseStockService.deductStock(doc.getOriginWarehouse(), item, line.getQuantity());
                }
                if (doc.getDestinationWarehouse() != null) {
                    warehouseStockService.addStock(doc.getDestinationWarehouse(), item, line.getQuantity());
                }
            }
        }
        return doc;
    }

    @Transactional
    public Document updateDocumentItems(Long id, List<DocumentItemRequest> dir) {
        if (dir == null || dir.isEmpty()) {
            throw new IllegalArgumentException("The document must have at least one item.");
        }
        Document doc = getDocumentById(id);

        if (doc.getDocumentType().getStockMovementEnabled()) {
            for (DocumentItem line : doc.getItems()) {
                if (doc.getOriginWarehouse() != null) {
                    warehouseStockService.addStock(doc.getOriginWarehouse(), line.getItem(), line.getQuantity());
                }
                if (doc.getDestinationWarehouse() != null) {
                    warehouseStockService.deductStock(doc.getDestinationWarehouse(), line.getItem(), line.getQuantity());
                }
            }
        }
        doc.getItems().clear();

        populateDocument(doc, dir);

        return documentRepository.save(doc);
    }
}