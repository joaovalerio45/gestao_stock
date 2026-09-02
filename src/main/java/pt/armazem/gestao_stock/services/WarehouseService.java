package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Warehouse;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.WarehouseRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with ID: " + id));
    }

    public Warehouse getActiveWarehouseById(Long id) {
        Warehouse warehouse = getWarehouseById(id);
        if (!warehouse.getActive()) {
            throw new BusinessRuleException("Warehouse '" + warehouse.getName() + "' is inactive.");
        }
        return warehouse;
    }
}
