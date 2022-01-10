package com.tqi.emprestimo.controller;


import com.tqi.emprestimo.model.AcompEmprestimo;
import com.tqi.emprestimo.model.ListaEmprestimo;
import com.tqi.emprestimo.service.AcompanhamentoService;
import com.tqi.emprestimo.service.ListaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoService acompanhamentoService;

    @GetMapping
    public List<AcompEmprestimo> getAcompanhamentoList(){
        return acompanhamentoService.findAll();

    }

    @GetMapping("/{idAcompanhamento}")
    public ResponseEntity<AcompEmprestimo> getAcompanhamentoByID(@PathVariable("idAcompanhamento")Long idAcompanhamento) throws Exception {
        return ResponseEntity.ok(acompanhamentoService.getById(idAcompanhamento).orElseThrow(() -> new NoSuchElementException("Acompanhamento não encontrado.")));

    }

}
