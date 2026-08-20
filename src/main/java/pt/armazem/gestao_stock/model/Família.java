package pt.armazem.gestao_stock.model;

import lombok.Getter;

@Getter
public enum Família {
    GA("GA", "Géneros Alimentares"),
    FR("FR", "Farmácia"),
    PL("PL", "Produtos de Limpeza"),
    MT("MT", "Material de Escritório"),
    PC("PC", "Puericultura"),
    PH("PH", "Produtos de Higiene"),
    PZ("PZ", "Produtos de Cozinha");

    private final String código;
    private final String descrição;

    Família(String código, String descrição) {
        this.código = código;
        this.descrição = descrição;
    }
}
