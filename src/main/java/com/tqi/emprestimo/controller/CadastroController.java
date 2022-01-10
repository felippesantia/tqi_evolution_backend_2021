package com.tqi.emprestimo.controller;


import com.tqi.emprestimo.model.Cadastro;
import com.tqi.emprestimo.model.ListaEmprestimo;
import com.tqi.emprestimo.service.CadastroService;
import com.tqi.emprestimo.service.ListaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    CadastroService cadastroService;

    @PostMapping
    public Cadastro createCadastro(@RequestBody Cadastro cadastro){
        return cadastroService.saveCadastro(cadastro);

    }

    @GetMapping
    public List<Cadastro> getCadastroList(){
        return cadastroService.findAll();

    }

    @GetMapping("/{idCadastro}")
    public ResponseEntity<Cadastro> getCadastroByID(@PathVariable("idCadastro")Long idCadastro) throws Exception {
        return ResponseEntity.ok(cadastroService.getById(idCadastro).orElseThrow(() -> new NoSuchElementException("Cadastro não encontrado.")));

    }

    @PutMapping
    public Cadastro updateCadastro(@RequestBody Cadastro cadastro){
        return cadastroService.updateCadastro(cadastro);

    }

    @DeleteMapping("/{idCadastro}")
    public ResponseEntity<Cadastro> deleteByID(@PathVariable("idCadastro")Long idCadastro) throws Exception {
        try {
            cadastroService.deleteCadastro(idCadastro);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Cadastro>) ResponseEntity.ok();

    }

}
