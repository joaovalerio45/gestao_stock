package pt.armazem.gestao_stock.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.armazem.gestao_stock.domain.enums.OperationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "documents",
    uniqueConstraints = {@UniqueConstraint( name = "document_operation_year_seq", columnNames = {"operation_type", "year", "sequence_number"})
    }
)
@Getter
@Setter
@NoArgsConstructor
public class Document {

    @
}