package com.tqi.emprestimo.controller;


import com.tqi.emprestimo.model.Emprestimo;
import com.tqi.emprestimo.service.EmprestimoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo createEmprestimo(@RequestBody Emprestimo emprestimo){
        return emprestimoService.saveEmprestimo(emprestimo);

    }

    @GetMapping
    public List<Emprestimo> getListaList(){
        return emprestimoService.findAll();

    }

    @GetMapping("/{idEmprestimo}")
    public ResponseEntity<Emprestimo> getEmprestimoByID(@PathVariable("idEmprestimo")Long idEmprestimo) throws Exception {
        return ResponseEntity.ok(emprestimoService.getById(idEmprestimo).orElseThrow(() -> new NoSuchElementException("Emprestimo não encontrada.")));

    }

    @PutMapping
    public Emprestimo updateEmprestimo(@RequestBody Emprestimo emprestimo){
        return emprestimoService.updateEmprestimo(emprestimo);

    }

    @DeleteMapping("/{idEmprestimo}")
    public ResponseEntity<Emprestimo> deleteByID(@PathVariable("idEmprestimo")Long idEmprestimo) throws Exception {
        try {
            emprestimoService.deleteEmprestimo(idEmprestimo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Emprestimo>) ResponseEntity.ok();

    }

}