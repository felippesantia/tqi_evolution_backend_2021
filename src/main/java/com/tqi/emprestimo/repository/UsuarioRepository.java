package com.tqi.emprestimo.repository;

import com.tqi.emprestimo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
