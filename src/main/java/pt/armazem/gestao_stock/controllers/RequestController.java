package pt.armazem.gestao_stock.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.armazem.gestao_stock.domain.entities.Request;
import pt.armazem.gestao_stock.services.RequestService;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/{id}")
    public Request fetchRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @GetMapping
    public List<Request> fetchAllRequests() {
        return requestService.getAllRequests();
    }
}
