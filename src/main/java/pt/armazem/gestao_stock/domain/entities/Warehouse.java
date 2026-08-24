package pt.gestao.stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "armazens")
@Getter
@Setter
@NoArgsConstructor
public class Warehouse{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String morada;

    @Column(nullable = false)
    private Boolean ativo = true;

}