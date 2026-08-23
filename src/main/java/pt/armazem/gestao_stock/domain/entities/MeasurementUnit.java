package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "unidades_medida")
@Getter
@Setter
@NoArgsConstructor
public class MeasurementUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String sigla;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(name = "permite_decimais", nullable = false)
    private Boolean permiteDecimais = false;

    @Column(nullable = false)
    private Boolean ativo = true;
}