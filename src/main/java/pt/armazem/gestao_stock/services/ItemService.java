package pt.armazem.gestao_stock.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Item;
import pt.armazem.gestao_stock.domain.entities.MeasurementUnit;
import pt.armazem.gestao_stock.domain.entities.SubFamily;
import pt.armazem.gestao_stock.dtos.ItemRequest;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.ItemRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SubFamilyService subFamilyService;
    private final MeasurementUnitService measurementUnitService;

    public Item createItem(ItemRequest itemRequest) {
        if (itemRepository.existsByCode(itemRequest.code())) {
            throw new BusinessRuleException("Item with code '" + itemRequest.code() + "' already exists.");
        }

        if (itemRepository.existsByName(itemRequest.name())) {
            throw new BusinessRuleException("Item with name '" + itemRequest.name() + "' already exists.");
        }

        SubFamily subFamily = subFamilyService.getActiveSubFamilyById(itemRequest.subFamilyId());
        MeasurementUnit measurementUnit = measurementUnitService.getActiveMeasurementUnitById(itemRequest.measurementUnitId());

        Item item = new Item();
        item.setActive(true);
        item.setCode(itemRequest.code());
        item.setName(itemRequest.name());
        item.setDescription(itemRequest.description());
        item.setStandardVatRate(itemRequest.standardVatRate());
        item.setSubFamily(subFamily);
        item.setMeasurementUnit(measurementUnit);

        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + id));
    }

    public Item getActiveItemById(Long id) {
        Item item = getItemById(id);
        if (!item.getActive()) {
            throw new BusinessRuleException("Item '" + item.getName() + "' is inactive.");
        }
        return item;
    }

    public Item toggleActiveItem(Long id) {
        Item item = getItemById(id);
        item.setActive(!item.getActive());
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, ItemRequest updateRequest) {
        Item item = getItemById(id);
        item.setDescription(updateRequest.description());
        item.setStandardVatRate(updateRequest.standardVatRate());
        item.setName(updateRequest.name());

        SubFamily subFamily = subFamilyService.getActiveSubFamilyById(updateRequest.subFamilyId());
        MeasurementUnit measurementUnit = measurementUnitService.getActiveMeasurementUnitById(updateRequest.measurementUnitId());

        item.setSubFamily(subFamily);
        item.setMeasurementUnit(measurementUnit);

        return itemRepository.save(item);
    }
}
