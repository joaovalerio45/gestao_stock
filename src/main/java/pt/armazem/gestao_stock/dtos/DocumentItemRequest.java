package pt.armazem.gestao_stock.dtos;

import java.math.BigDecimal;

public record DocumentItemRequest(
    Long itemId,
    BigDecimal quantity,
    BigDecimal unitPriceExclVat,
    BigDecimal vatRate
) {}

