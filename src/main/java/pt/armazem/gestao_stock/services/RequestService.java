package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Request;
import pt.armazem.gestao_stock.domain.enums.RequestState;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.RequestRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Request not found with ID: " + id));
    }

    public Request getPendingRequestById(Long id) {
        Request request = getRequestById(id);
        if (request.getState() != RequestState.PENDING) {
            throw new BusinessRuleException("Request '" + request.getNumber() + "' is not in a PENDING state.");
        }
        return request;
    }
}

