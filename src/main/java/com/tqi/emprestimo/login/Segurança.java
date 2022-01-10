package com.tqi.emprestimo.login;


import com.tqi.emprestimo.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Path("/login")
public class Segurança {

    @NameBinding
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE,ElementType.METHOD})
    public @interface Authorize { }


        private final SecretKey CHAVE = Keys.hmacShaKeyFor(
                "7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
                        .getBytes(StandardCharsets.UTF_8));

        @POST
        @Produces(MediaType.TEXT_PLAIN)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response post(Usuario usuario)
        {
            try{
                if(
                        usuario.getEmail().equals("emprestimo@tqi.com.br")
                                &&
                                usuario.getSenha().equals("1234")
                )
                {
                    String jwtToken = Jwts.builder()
                            .setSubject(usuario.getEmail())
                            .setIssuer("localhost:8080")
                            .setIssuedAt(new Date())
                            .setExpiration(
                                    Date.from(
                                            LocalDateTime.now().plusMinutes(15L)
                                                    .atZone(ZoneId.systemDefault())
                                                    .toInstant()))
                            .signWith(CHAVE, SignatureAlgorithm.RS512)
                            .compact();

                    return Response.status(Response.Status.OK).entity(jwtToken).build();
                }
                else
                    return Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Usuário e/ou senha inválidos").build();
            }
            catch(Exception ex)
            {
                return Response.status(
                                Response.Status.INTERNAL_SERVER_ERROR
                        ).entity(ex.getMessage())
                        .build();
            }
        }
}