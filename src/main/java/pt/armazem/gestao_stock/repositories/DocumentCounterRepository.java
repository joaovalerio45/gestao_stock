package pt.armazem.gestao_stock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.DocumentCounter;
import pt.armazem.gestao_stock.domain.enums.OperationType;

public interface DocumentCounterRepository extends JpaRepository<DocumentCounter,Long>{
    Optional<DocumentCounter> findByOperationTypeAndYear(OperationType operationType, Integer year);
}
