package com.tqi.emprestimo.controller;

import com.tqi.emprestimo.model.Usuario;
import com.tqi.emprestimo.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.NoSuchElementException;


    @RestController
    @RequestMapping("/usuario")
    public class UsuarioController {

        @Autowired
        UsuarioService usuarioService;

        @PostMapping
        public Usuario createusuario(@RequestBody Usuario usuario) {
            return usuarioService.saveusuario(usuario);

        }

        @GET
        @GetMapping
        @Produces(MediaType.APPLICATION_JSON)
        public List<Usuario> getusuarioList() {
            return usuarioService.findAll();

        }

        @GET
        @GetMapping("/{idUsuario}")
        @Produces(MediaType.APPLICATION_JSON)
        public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
            return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado.")));

        }

        @PutMapping
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Usuario updateUsuario(@RequestBody Usuario usuario) {
            return usuarioService.updateUsuario(usuario);

        }

        @DeleteMapping("/{idUsuario}")
        public ResponseEntity<Usuario> deleteByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
            try {
                usuarioService.deleteUsuario(idUsuario);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return (ResponseEntity<Usuario>) ResponseEntity.ok();

        }

}

