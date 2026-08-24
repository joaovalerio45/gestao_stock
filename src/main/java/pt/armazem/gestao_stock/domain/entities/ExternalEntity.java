package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.armazem.gestao_stock.domain.enums.EntityType;

@Entity
@Table(name = "entidades")
@Setter
@Getter
@NoArgsConstructor
public class ExternalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String abreviatura;

    @Column(length = 9)
    private String nif;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EntityType tipo;

    @Column(nullable = false)
    private Boolean ativo = true;
}
