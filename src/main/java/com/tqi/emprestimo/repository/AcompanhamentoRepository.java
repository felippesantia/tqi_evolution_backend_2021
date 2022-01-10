package com.tqi.emprestimo.repository;

import com.tqi.emprestimo.model.AcompEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<AcompEmprestimo,Long> {


}
