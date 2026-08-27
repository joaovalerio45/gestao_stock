package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Item;
import pt.armazem.gestao_stock.domain.entities.MeasurementUnit;
import pt.armazem.gestao_stock.domain.entities.SubFamily;
import pt.armazem.gestao_stock.dtos.CreateItemRequest;
import pt.armazem.gestao_stock.repositories.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SubFamilyRepository subFamilyRepository;
    private final MeasurementUnitRepository measurementUnitRepository;

    public Item createItem(CreateItemRequest itemRequest){
        if(itemRepository.existsByCode(itemRequest.code())){
            throw new IllegalArgumentException("Item with code " + itemRequest.code() + " already exists");
        }

        if(itemRepository.existsByName(itemRequest.name())){
            throw new IllegalArgumentException("Item with name " + itemRequest.name() + " already exists");
        }

        SubFamily subFamily = subFamilyRepository.findById(itemRequest.subFamilyId())
            .orElseThrow(() -> new IllegalArgumentException("SubFamily not found with ID: " + itemRequest.subFamilyId()));

        MeasurementUnit measurementUnit = measurementUnitRepository.findById(itemRequest.measurementUnitId())
            .orElseThrow(() -> new IllegalArgumentException("MeasurementUnit not found with ID: " + itemRequest.measurementUnitId()));

        Item item = new Item();
        item.setActive(true);
        item.setCode(itemRequest.code());
        item.setName(itemRequest.name());
        item.setSubFamily(subFamily);
        item.setMeasurementUnit(measurementUnit);

        return itemRepository.save(item);
    }

}
