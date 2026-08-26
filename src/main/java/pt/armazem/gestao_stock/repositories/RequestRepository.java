package pt.armazem.gestao_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.Request;

public interface RequestRepository extends JpaRepository<Request,Long>{

}
