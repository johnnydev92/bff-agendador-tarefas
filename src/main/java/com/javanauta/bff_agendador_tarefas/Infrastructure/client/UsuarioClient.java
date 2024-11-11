package com.javanauta.bff_agendador_tarefas.Infrastructure.client;


import com.javanauta.bff_agendador_tarefas.Business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);


    @PostMapping
    UsuarioDTOResponse salvaUsuario (@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login (@RequestBody LoginDTORequest usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadoUsuario(@RequestBody UsuarioDTORequest dto,
                                           @RequestHeader("Authorization") String token);


    @PutMapping("/endereco")
    EnderecoDTOResponse atulizaEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTOResponse atulizaTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);


}
