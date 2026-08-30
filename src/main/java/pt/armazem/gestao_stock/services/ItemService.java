package pt.armazem.gestao_stock.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Item;
import pt.armazem.gestao_stock.domain.entities.MeasurementUnit;
import pt.armazem.gestao_stock.domain.entities.SubFamily;
import pt.armazem.gestao_stock.dtos.ItemRequest;
import pt.armazem.gestao_stock.repositories.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SubFamilyRepository subFamilyRepository;
    private final MeasurementUnitRepository measurementUnitRepository;

    public Item createItem(ItemRequest itemRequest){
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
        item.setDescription(itemRequest.description());
        item.setStandardVatRate(itemRequest.standardVatRate());
        item.setName(itemRequest.name());
        item.setSubFamily(subFamily);
        item.setMeasurementUnit(measurementUnit);

        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public Item getItemById(Long id){
        return itemRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
    }

    @Transactional
    public Item toggleActiveItem(Long id){
        Item item = getItemById(id);
        item.setActive(!item.getActive());
        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItems(){
        return itemRepository.findAll();
        
    }

    public Item updateItem(Long id, ItemRequest updateRequest){
        Item item = getItemById(id);
        item.setDescription(updateRequest.description());
        item.setStandardVatRate(updateRequest.standardVatRate());
        item.setName(updateRequest.name());

        SubFamily subFamily = subFamilyRepository.findById(updateRequest.subFamilyId())
            .orElseThrow(() -> new IllegalArgumentException("SubFamily not found with ID: " + updateRequest.subFamilyId()));

        MeasurementUnit measurementUnit = measurementUnitRepository.findById(updateRequest.measurementUnitId())
            .orElseThrow(() -> new IllegalArgumentException("MeasurementUnit not found with ID: " + updateRequest.measurementUnitId()));


        item.setSubFamily(subFamily);
        item.setMeasurementUnit(measurementUnit);
        
        return itemRepository.save(item);
    }

    



}
