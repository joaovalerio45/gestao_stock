package pt.armazem.gestao_stock.dtos;

public record CreateItemRequest(String code, String name, Long subFamilyId, Long measurementUnitId) {

}
