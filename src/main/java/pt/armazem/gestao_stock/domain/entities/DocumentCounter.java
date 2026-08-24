package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.armazem.gestao_stock.domain.enums.OperationType;

@Entity
@Table(
    name = "contadores_operacao",
    uniqueConstraints = { @UniqueConstraint( name = "uk_contador_natureza_ano", columnNames = {"natureza", "ano"})}
)
@Getter
@Setter
@NoArgsConstructor
public class DocumentCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OperationType natureza;

    @Column(nullable = false)
    private Integer ano;

    @Column(name = "ultimo_numero", nullable = false)
    private Long ultimoNumero = 0L;
}
