package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.ExternalEntity;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.ExternalEntityRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ExternalEntityService {

    private final ExternalEntityRepository externalEntityRepository;

    public ExternalEntity getExternalEntityById(Long id) {
        return externalEntityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ExternalEntity not found with ID: " + id));
    }

    public ExternalEntity getActiveExternalEntityById(Long id) {
        ExternalEntity entity = getExternalEntityById(id);
        if (!entity.getActive()) {
            throw new BusinessRuleException("External entity '" + entity.getName() + "' is inactive.");
        }
        return entity;
    }
}

