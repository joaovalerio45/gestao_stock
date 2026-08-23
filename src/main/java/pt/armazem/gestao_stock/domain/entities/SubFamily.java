package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "subfamilias", 
    uniqueConstraints = {
        @UniqueConstraint(name = "subfamilia_familia_codigo", columnNames = {"familia_id", "codigo"})
    }
)
@Getter
@Setter
@NoArgsConstructor
public class SubFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "familia_id", nullable = false)
    private Family familia;

    @Column(nullable = false, length = 10)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo = true;
}
