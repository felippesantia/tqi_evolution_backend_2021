package com.tqi.emprestimo.repository;

import com.tqi.emprestimo.model.DetEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalheRepository extends JpaRepository<DetEmprestimo,Long> {


}
