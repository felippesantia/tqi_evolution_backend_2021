package com.tqi.emprestimo.model;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class DetEmprestimo {
    @Id
    private Long codDetEmprestimo;
    private int valEmprestimo;
    private int qntdParcelas;
    private String dataPriParcela;
    private String email;
    private int renda;
    @OneToOne
    private Emprestimo emprestimo;

}
