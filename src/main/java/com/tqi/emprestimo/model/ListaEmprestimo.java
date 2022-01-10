package com.tqi.emprestimo.model;


import lombok.*;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class ListaEmprestimo {
    @Id
    @GeneratedValue
    private Long idListaEmprestimo;
    private String valor_emprestimo;
    private int qntd_parcelas;
}
