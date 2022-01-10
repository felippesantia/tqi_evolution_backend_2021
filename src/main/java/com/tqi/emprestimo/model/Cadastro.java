package com.tqi.emprestimo.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Cadastro {
    @Id
    private long cad_id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;
    private int renda;
    private String senha;

}
