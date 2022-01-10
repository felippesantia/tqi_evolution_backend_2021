package com.tqi.emprestimo.service;

import com.tqi.emprestimo.model.AcompEmprestimo;
import com.tqi.emprestimo.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoService {

    static AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    public AcompanhamentoService(AcompanhamentoRepository acompanhamentoRepository) {
        AcompanhamentoService.acompanhamentoRepository = acompanhamentoRepository;
    }

    public List<AcompEmprestimo> findAll() {
        return acompanhamentoRepository.findAll();
    }

    public Optional<AcompEmprestimo> getById(Long idAcompanhamento) {
        return acompanhamentoRepository.findById(idAcompanhamento);
    }


}