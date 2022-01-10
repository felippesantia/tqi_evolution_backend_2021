package com.tqi.emprestimo.repository;

import com.tqi.emprestimo.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro,Long> {


}