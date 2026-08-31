package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Document;
import pt.armazem.gestao_stock.domain.entities.DocumentCounter;
import pt.armazem.gestao_stock.domain.enums.OperationType;
import pt.armazem.gestao_stock.dtos.DocumentRequest;
import pt.armazem.gestao_stock.repositories.DocumentCounterRepository;
import pt.armazem.gestao_stock.repositories.DocumentRepository;
import pt.armazem.gestao_stock.repositories.DocumentTypeRepository;

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

    @Transactional
    public Document createDocument(DocumentRequest dr){
        
    }


    
}
