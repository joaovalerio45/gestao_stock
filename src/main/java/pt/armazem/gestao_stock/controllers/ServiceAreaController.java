package pt.armazem.gestao_stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.services.ServiceAreaService;

@RestController
@RequestMapping("/api/service-areas")
@RequiredArgsConstructor
public class ServiceAreaController {

    private final ServiceAreaService serviceAreaService;

}

