package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.SubFamily;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.SubFamilyRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class SubFamilyService {

    private final SubFamilyRepository subFamilyRepository;

    public SubFamily getSubFamilyById(Long id) {
        return subFamilyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SubFamily not found with ID: " + id));
    }

    public SubFamily getActiveSubFamilyById(Long id) {
        SubFamily subFamily = getSubFamilyById(id);
        if (!subFamily.getActive()) {
            throw new BusinessRuleException("Subfamily '" + subFamily.getName() + "' is inactive.");
        }
        return subFamily;
    }
}
