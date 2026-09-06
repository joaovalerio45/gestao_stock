package pt.armazem.gestao_stock.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Request;
import pt.armazem.gestao_stock.domain.entities.RequestItem;
import pt.armazem.gestao_stock.domain.enums.OperationType;
import pt.armazem.gestao_stock.domain.enums.RequestState;
import pt.armazem.gestao_stock.dtos.RequestItemRequest;
import pt.armazem.gestao_stock.dtos.RequestRequest;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.RequestRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final ServiceAreaService serviceAreaService;
    private final WarehouseService warehouseService;
    private final DocumentCounterService documentCounterService;
    private final ItemService itemService;

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Request not found with ID: " + id));
    }

    public java.util.List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getPendingRequestById(Long id) {
        Request request = getRequestById(id);
        if (request.getState() != RequestState.PENDING) {
            throw new BusinessRuleException("Request '" + request.getNumber() + "' is not in a PENDING state.");
        }
        return request;
    }

    public Request createRequest(RequestRequest request){
        Request req = new Request();
        req.setServiceArea(serviceAreaService.getActiveServiceAreaById(request.serviceAreaId()));
        req.setWarehouse(warehouseService.getActiveWarehouseById(request.warehouseId()));
        
        int year = LocalDate.now().getYear();
        Long seq = documentCounterService.incrementDocCounter(OperationType.REQUEST,year);
        String reqNumber = String.format("%s-%d/%d", OperationType.REQUEST.getPrefix(), year, seq);
        req.setNumber(reqNumber);

        if(request.requestNotes() != null){
            req.setRequestNotes(request.requestNotes());
        }

        for(RequestItemRequest line : request.items()){
            RequestItem requestItem = new RequestItem();
            requestItem.setItem(itemService.getActiveItemById(line.itemId()));
            requestItem.setRequestedQuantity(line.requestedQuantity());
            requestItem.setRequest(req);
            req.getItems().add(requestItem);
        }

        return requestRepository.save(req);
    }

    
}

