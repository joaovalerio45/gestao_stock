package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.ServiceArea;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.ServiceAreaRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceAreaService {

    private final ServiceAreaRepository serviceAreaRepository;

    public ServiceArea getServiceAreaById(Long id) {
        return serviceAreaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ServiceArea not found with ID: " + id));
    }

    public ServiceArea getActiveServiceAreaById(Long id) {
        ServiceArea serviceArea = getServiceAreaById(id);
        if (!serviceArea.getActive()) {
            throw new BusinessRuleException("Service area '" + serviceArea.getName() + "' is inactive.");
        }
        return serviceArea;
    }
}
