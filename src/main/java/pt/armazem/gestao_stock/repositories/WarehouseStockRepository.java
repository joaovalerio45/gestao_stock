package pt.armazem.gestao_stock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.WarehouseStock;

public interface WarehouseStockRepository extends JpaRepository<WarehouseStock,Long>{

    Optional<WarehouseStock> findByWarehouseIdAndItemId(Long warehouseId, Long itemId);
}
