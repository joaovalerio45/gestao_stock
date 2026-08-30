package pt.armazem.gestao_stock.services;

import java.math.BigDecimal;
import java.util.Optional;

import pt.armazem.gestao_stock.domain.entities.WarehouseStock;
import pt.armazem.gestao_stock.domain.entities.Item;
import pt.armazem.gestao_stock.domain.entities.Warehouse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.repositories.ItemRepository;
import pt.armazem.gestao_stock.repositories.WarehouseRepository;
import pt.armazem.gestao_stock.repositories.WarehouseStockRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseStockService {

    private final WarehouseStockRepository warehouseStockRepository;
    private final WarehouseService warehouseService;
    private final ItemService itemService;


    @Transactional(readOnly = true)
    public WarehouseStock getWarehouseStock(Long warehouseId, Long itemId){
        return warehouseStockRepository.findByWarehouseIdAndItemId(warehouseId, itemId)
            .orElseThrow( () -> new IllegalArgumentException("No stock found for item " + itemId + " in warehouse " + warehouseId + "."));
    }

    @Transactional(readOnly = true)
    public BigDecimal getStockQuantity(Long warehouseId, Long itemId){
        return getWarehouseStock(warehouseId, itemId).getCurrentStock();
    }

    @Transactional
    public WarehouseStock addStock(Long warehouseId, Long itemId, BigDecimal quantity){
        if(quantity.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        WarehouseStock ws = warehouseStockRepository.findByWarehouseIdAndItemId(warehouseId, itemId)
            .orElseGet(() -> {
                Item item = itemService.getItemById(itemId);
                Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
                WarehouseStock wsNew = new WarehouseStock();
                wsNew.setItem(item);
                wsNew.setWarehouse(warehouse);
                return wsNew;
            });


        ws.setCurrentStock(ws.getCurrentStock().add(quantity));
        return warehouseStockRepository.save(ws);
    
    }

    @Transactional
    public WarehouseStock deductStock(Long warehouseId, Long itemId, BigDecimal quantity){
        if(quantity.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        WarehouseStock ws = getWarehouseStock(warehouseId, itemId);

        if(quantity.compareTo(ws.getCurrentStock()) > 0){
            throw new IllegalArgumentException("The quantity must not exceed current stock.");
        }

        ws.setCurrentStock(ws.getCurrentStock().subtract(quantity));
        return warehouseStockRepository.save(ws);
    }
}
