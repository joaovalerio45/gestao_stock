package pt.armazem.gestao_stock.dtos;

import java.time.LocalDate;
import java.util.List;

public record DocumentRequest(
    Long documentTypeId,
    String originDocumentNumber,
    LocalDate documentDate,
    Long originWarehouseId,
    Long originServiceAreaId,
    Long destinationWarehouseId,
    Long destinationServiceAreaId,
    List<DocumentItemRequest> items,
    Long requestId,
    String observations
) {}

