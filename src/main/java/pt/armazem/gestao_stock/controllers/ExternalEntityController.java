package pt.armazem.gestao_stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.services.ExternalEntityService;

@RestController
@RequestMapping("/api/external-entities")
@RequiredArgsConstructor
public class ExternalEntityController {

    private final ExternalEntityService externalEntityService;

}

