package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.MeasurementUnit;
import pt.armazem.gestao_stock.repositories.MeasurementUnitRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MeasurementUnitService {

    private final MeasurementUnitRepository measurementUnitRepository;

    @Transactional(readOnly = true)
    public MeasurementUnit getMeasurementUnitById(Long id) {
        return measurementUnitRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("MeasurementUnit not found with ID: " + id));
    }
}

