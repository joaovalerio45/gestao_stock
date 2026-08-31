package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.DocumentType;
import pt.armazem.gestao_stock.repositories.DocumentTypeRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    @Transactional(readOnly = true)
    public DocumentType getDocumentTypeById(Long id) {
        return documentTypeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("DocumentType not found with ID: " + id));
    }
}

