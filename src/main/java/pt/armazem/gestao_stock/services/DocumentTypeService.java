package pt.armazem.gestao_stock.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.DocumentType;
import pt.armazem.gestao_stock.exceptions.BusinessRuleException;
import pt.armazem.gestao_stock.exceptions.ResourceNotFoundException;
import pt.armazem.gestao_stock.repositories.DocumentTypeRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    public DocumentType getDocumentTypeById(Long id) {
        return documentTypeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found with ID: " + id));
    }

    public DocumentType getActiveDocumentTypeById(Long id) {
        DocumentType documentType = getDocumentTypeById(id);
        if (!documentType.getActive()) {
            throw new BusinessRuleException("Document type '" + documentType.getName() + "' is inactive.");
        }
        return documentType;
    }
}
