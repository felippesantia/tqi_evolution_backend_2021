package com.tqi.emprestimo.controller;


import com.tqi.emprestimo.model.DetEmprestimo;
import com.tqi.emprestimo.model.ListaEmprestimo;
import com.tqi.emprestimo.service.DetalheService;
import com.tqi.emprestimo.service.ListaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/detalhe")
public class DetalheController {

    @Autowired
    DetalheService detalheService;

    @PostMapping
    public DetEmprestimo createDetalhe(@RequestBody DetEmprestimo detEmprestimo){
        return detalheService.saveDetalhe(detEmprestimo);

    }

    @GetMapping
    public List<DetEmprestimo> getDetalheList(){
        return detalheService.findAll();

    }

    @GetMapping("/{idDetalhe}")
    public ResponseEntity<DetEmprestimo> getDetalheByID(@PathVariable("idDetalhe")Long idDetalhe) throws Exception {
        return ResponseEntity.ok(detalheService.getById(idDetalhe).orElseThrow(() -> new NoSuchElementException("Detalhamento não encontrado.")));

    }

    @PutMapping
    public DetEmprestimo updateDetalhe(@RequestBody DetEmprestimo detEmprestimo){
        return detalheService.updateDetalhe(detEmprestimo);

    }

    @DeleteMapping("/{idDetalhe}")
    public ResponseEntity<DetEmprestimo> deleteByID(@PathVariable("idDetalhe")Long idDetalhe) throws Exception {
        try {
            detalheService.deleteDetalhe(idDetalhe);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<DetEmprestimo>) ResponseEntity.ok();

    }

}