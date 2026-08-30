package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.SubFamily;
import pt.armazem.gestao_stock.repositories.SubFamilyRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class SubFamilyService {

    private final SubFamilyRepository subFamilyRepository;

    @Transactional(readOnly = true)
    public SubFamily getSubFamilyById(Long id) {
        return subFamilyRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("SubFamily not found with ID: " + id));
    }
}

