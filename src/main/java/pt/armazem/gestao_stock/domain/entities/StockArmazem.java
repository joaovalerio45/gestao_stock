package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(
    name = "stock_armazem",
    uniqueConstraints = {
        @UniqueConstraint( name = "stock_armazem_artigo", columnNames = {"armazem_id", "artigo_id"})
    }
)
@Getter
@Setter
@NoArgsConstructor 
public class StockArmazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "armazem_id", nullable = false)
    private Warehouse armazem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artigo_id", nullable = false)
    private Item artigo;

    @Column(name = "stock_atual", nullable = false, precision = 12, scale = 3)
    private BigDecimal stockAtual = BigDecimal.ZERO;

    @Column(name = "stock_minimo", nullable = false, precision = 12, scale = 3)
    private BigDecimal stockMinimo = BigDecimal.ZERO;

}