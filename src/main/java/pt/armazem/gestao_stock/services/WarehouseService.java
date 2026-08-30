package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Warehouse;
import pt.armazem.gestao_stock.repositories.ItemRepository;
import pt.armazem.gestao_stock.repositories.WarehouseRepository;
import pt.armazem.gestao_stock.repositories.WarehouseStockRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Transactional(readOnly = true)
    public Warehouse getWarehouseById(Long id){
        return warehouseRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Warehouse not found with ID: " + id));
    }
}
