package pt.armazem.gestao_stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.services.SubFamilyService;

@RestController
@RequestMapping("/api/sub-families")
@RequiredArgsConstructor
public class SubFamilyController {

    private final SubFamilyService subFamilyService;

}

