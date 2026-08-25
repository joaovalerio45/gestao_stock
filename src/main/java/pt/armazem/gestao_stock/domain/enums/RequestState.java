package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum RequestState {
    PENDENTE,       // PENDING
    EM_PREPARACAO,  // PREPARING
    ENVIADO,        // SENT
    RECEBIDO,       // RECEIVED
    CANCELADO;      // CANCELED
}
