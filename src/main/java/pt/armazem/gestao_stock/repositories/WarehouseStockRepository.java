package pt.armazem.gestao_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.WarehouseStock;

public interface WarehouseStockRepository extends JpaRepository<WarehouseStock,Long>{

}
