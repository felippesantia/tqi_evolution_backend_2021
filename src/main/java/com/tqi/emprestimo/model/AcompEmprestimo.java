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
public class AcompEmprestimo {

    @EqualsAndHashCode
    @Embeddable
    @Getter
    @Setter
    public class AcompEmprestimoId implements Serializable{
        private long idListaEmprestimo;
        private long idDetEmprestimo;
    }
    @EmbeddedId
    private AcompEmprestimoId acompEmprestimoId;
    @OneToOne
    private ListaEmprestimo listaEmprestimo;
    @OneToOne
    private DetEmprestimo detEmprestimo;

}
