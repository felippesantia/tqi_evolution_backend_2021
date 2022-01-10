package com.tqi.emprestimo.model;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Emprestimo {
    @Id
    private long codEmprestimo;
    private int valEmprestimo;
    private int qntdParcelas;
    private LocalDateTime dataPriParcela;
    @ManyToOne
    private ListaEmprestimo listaEmprestimo;

}
