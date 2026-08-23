package pt.armazem.gestao_stock.domain.enums;

import lombok.Getter;

@Getter
public enum RequestState {
    PENDENTE,
    EM_PREPARACAO,
    ATENDIDO,
    CANCELADO;
}
