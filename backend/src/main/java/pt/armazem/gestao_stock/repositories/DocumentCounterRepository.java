package pt.armazem.gestao_stock.repositories;

import java.util.Optional;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.DocumentCounter;
import pt.armazem.gestao_stock.domain.enums.OperationType;

public interface DocumentCounterRepository extends JpaRepository<DocumentCounter,Long>{
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<DocumentCounter> findByOperationTypeAndYear(OperationType operationType, Integer year);
}
