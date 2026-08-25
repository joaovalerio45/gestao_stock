package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum OperationType {
    ENTRADA("ENT"),         // ENTRY
    SAIDA("SAI"),           // WITHDRAWAL
    DEVOLUCAO("DEV"),       // RETURN
    TRANSFERENCIA("TRF"),   // TRANSFER
    AJUSTE("AJU");          // ADJUSTMENT

    private final String prefix;

    OperationType(String prefix){
        this.prefix = prefix;
}


}
