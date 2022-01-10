package com.tqi.emprestimo.controller;


import com.tqi.emprestimo.model.ListaEmprestimo;
import com.tqi.emprestimo.service.ListaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lista")
public class ListaEmprestimoController {

    @Autowired
    ListaService listaService;

    @PostMapping
    public ListaEmprestimo createLista(@RequestBody ListaEmprestimo listaEmprestimo){
        return listaService.saveLista(listaEmprestimo);

    }

    @GetMapping
    public List<ListaEmprestimo> getListaList(){
        return listaService.findAll();

    }

    @GetMapping("/{idLista}")
    public ResponseEntity<ListaEmprestimo> getListaByID(@PathVariable("idLista")Long idLista) throws Exception {
        return ResponseEntity.ok(listaService.getById(idLista).orElseThrow(() -> new NoSuchElementException("Lista não encontrada.")));

    }

    @PutMapping
    public ListaEmprestimo updateLista(@RequestBody ListaEmprestimo listaEmprestimo){
        return listaService.updateLista(listaEmprestimo);

    }

}
