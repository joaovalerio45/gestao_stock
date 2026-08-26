package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum RequestState {
    PENDING,
    PREPARING,
    SENT,
    RECEIVED,
    CANCELED,
}
