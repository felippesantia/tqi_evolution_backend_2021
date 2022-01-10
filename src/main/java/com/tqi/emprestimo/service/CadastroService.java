package com.tqi.emprestimo.service;

import com.tqi.emprestimo.model.Cadastro;
import com.tqi.emprestimo.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    static CadastroRepository cadastroRepository;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository) {
        CadastroService.cadastroRepository = cadastroRepository;
    }


    public Cadastro saveCadastro(Cadastro cadastro){
        return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> findAll() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> getById(Long idCadastro) {
        return cadastroRepository.findById(idCadastro);
    }

    public Cadastro updateCadastro(Cadastro cadastro){
        return cadastroRepository.save(cadastro);
    }

    public void deleteCadastro(Long idCadastro) {
        cadastroRepository.deleteById(idCadastro);
    }

}