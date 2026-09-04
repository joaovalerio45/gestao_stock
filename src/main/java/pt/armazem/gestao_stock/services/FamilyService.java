package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Family;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.FamilyRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    public Family getFamilyById(Long id) {
        return familyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Family not found with ID: " + id));
    }

    public Family getActiveFamilyById(Long id) {
        Family family = getFamilyById(id);
        if (!family.getActive()) {
            throw new BusinessRuleException("Family '" + family.getName() + "' is inactive.");
        }
        return family;
    }
}

