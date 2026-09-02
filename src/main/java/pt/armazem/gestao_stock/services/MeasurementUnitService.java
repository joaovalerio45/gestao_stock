package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.MeasurementUnit;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.MeasurementUnitRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MeasurementUnitService {

    private final MeasurementUnitRepository measurementUnitRepository;

    public MeasurementUnit getMeasurementUnitById(Long id) {
        return measurementUnitRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("MeasurementUnit not found with ID: " + id));
    }

    public MeasurementUnit getActiveMeasurementUnitById(Long id) {
        MeasurementUnit unit = getMeasurementUnitById(id);
        if (!unit.getActive()) {
            throw new BusinessRuleException("Measurement unit '" + unit.getName() + "' is inactive.");
        }
        return unit;
    }
}
