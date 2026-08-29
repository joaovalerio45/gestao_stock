package pt.armazem.gestao_stock.dtos;

import java.math.BigDecimal;

public record ItemRequest(String code, String name, Long subFamilyId, Long measurementUnitId, String description, BigDecimal standardVatRate) {

}
