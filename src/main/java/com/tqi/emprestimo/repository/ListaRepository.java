package com.tqi.emprestimo.repository;

import com.tqi.emprestimo.model.ListaEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<ListaEmprestimo,Long> {


}
