package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum OperationType {
    ENTRADA("ENT"),
    SAIDA("SAI"),
    DEVOLUCAO("DEV"),
    TRANSFERENCIA("TRF"),
    Ajuste("AJU");

    private final String prefixo;

    OperationType(String prefixo){
        this.prefixo = prefixo;
}


}
