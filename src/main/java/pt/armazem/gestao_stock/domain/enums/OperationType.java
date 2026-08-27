package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum OperationType {
    ENTRY("ENT"),
    WITHDRAWAL("SAI"),
    RETURN("DEV"),
    TRANSFER("TRF"),
    ADJUSTMENT("AJU");

    private final String prefix;

    OperationType(String prefix){
        this.prefix = prefix;
}


}
