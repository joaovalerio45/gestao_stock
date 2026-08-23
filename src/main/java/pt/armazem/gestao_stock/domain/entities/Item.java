package pt.armazem.gestao_stock.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artigos")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subfamilia_id" , nullable = false)
    private SubFamily subfamilia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unidadeMedida_id", nullable = false)
    private MeasurementUnit unidadeMedida;

    @Column(name = "ultimo_preco_unitario_sem_iva", precision = 12, scale = 4)
    private BigDecimal ultimoPrecoUnitarioSemIva;

    @Column(name = "taxa_iva_padrao", precision = 5, scale = 4)
    private BigDecimal taxaIvaPadrao = new BigDecimal("6.00");
    
    @Column(nullable = false)
    private Boolean ativo = true;


}
