package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.ServiceArea;
import pt.armazem.gestao_stock.repositories.ServiceAreaRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceAreaService {

    private final ServiceAreaRepository serviceAreaRepository;

    @Transactional(readOnly = true)
    public ServiceArea getServiceAreaById(Long id) {
        return serviceAreaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ServiceArea not found with ID: " + id));
    }
}

