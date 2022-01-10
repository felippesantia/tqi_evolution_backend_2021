package com.tqi.emprestimo.service;

import com.tqi.emprestimo.model.Emprestimo;
import com.tqi.emprestimo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    static EmprestimoRepository emprestimoRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        EmprestimoService.emprestimoRepository = emprestimoRepository;
    }


    public Emprestimo saveEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }


    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> getById(Long idEmprestimo) {
        return emprestimoRepository.findById(idEmprestimo);
    }

    public Emprestimo updateEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteEmprestimo(Long idEmprestimo) {
        emprestimoRepository.deleteById(idEmprestimo);
    }

}