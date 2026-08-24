package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.armazem.gestao_stock.domain.enums.OperationType;

@Entity
@Table(name = "tipos_documento")
@Getter
@Setter
@NoArgsConstructor
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OperationType natureza;

    @Column(name = "movimenta_stock", nullable = false)
    private Boolean movimentaStock = true;

    @Column(nullable = false)
    private Boolean ativo = true;
}
