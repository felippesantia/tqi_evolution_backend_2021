package com.tqi.emprestimo.service;

import com.tqi.emprestimo.model.DetEmprestimo;
import com.tqi.emprestimo.repository.DetalheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalheService {

    static DetalheRepository detalheRepository;

    @Autowired
    public DetalheService(DetalheRepository detalheRepository) {
        DetalheService.detalheRepository = detalheRepository;
    }


    public DetEmprestimo saveDetalhe(DetEmprestimo detEmprestimo){
        return detalheRepository.save(detEmprestimo);
    }

    public List<DetEmprestimo> findAll() {
        return detalheRepository.findAll();
    }

    public Optional<DetEmprestimo> getById(Long idDetalhe) {
        return detalheRepository.findById(idDetalhe);
    }

    public DetEmprestimo updateDetalhe(DetEmprestimo detEmprestimo){
        return detalheRepository.save(detEmprestimo);
    }

    public void deleteDetalhe(Long idDetalhe) {
        detalheRepository.deleteById(idDetalhe);
    }

}
