package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.DocumentCounter;
import pt.armazem.gestao_stock.domain.enums.OperationType;
import pt.armazem.gestao_stock.repositories.DocumentCounterRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentCounterService {

    private final DocumentCounterRepository documentCounterRepository;
    

    @Transactional
    public Long incrementDocCounter(OperationType ot, Integer year){
        DocumentCounter dc = documentCounterRepository.findByOperationTypeAndYear(ot, year)
            .orElseGet(() -> {
                DocumentCounter dcNew = new DocumentCounter();
                dcNew.setOperationType(ot);
                dcNew.setYear(year);
                dcNew.setLastNumber(0L);
                return dcNew;
            });
            Long nextNumber = dc.getLastNumber() + 1;
            dc.setLastNumber(nextNumber);
            documentCounterRepository.save(dc);
            return nextNumber;
        
    }

}
