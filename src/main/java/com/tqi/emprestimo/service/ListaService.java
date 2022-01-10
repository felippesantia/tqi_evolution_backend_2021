package com.tqi.emprestimo.service;

import com.tqi.emprestimo.model.ListaEmprestimo;
import com.tqi.emprestimo.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {
    
    static ListaRepository listaRepository;
    
    @Autowired
    public ListaService(ListaRepository listaRepository) {
        ListaService.listaRepository = listaRepository;
    }


    public ListaEmprestimo saveLista(ListaEmprestimo listaEmprestimo){
        return listaRepository.save(listaEmprestimo);
    }

    public List<ListaEmprestimo> findAll() {
        return listaRepository.findAll();
    }

    public Optional<ListaEmprestimo> getById(Long idLista) {
        return listaRepository.findById(idLista);
    }

    public ListaEmprestimo updateLista(ListaEmprestimo listaEmprestimo){
        return listaRepository.save(listaEmprestimo);
    }

}
