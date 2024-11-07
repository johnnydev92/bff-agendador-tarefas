package com.javanauta.bff_agendador_tarefas.Infrastructure.client;


import com.javanauta.bff_agendador_tarefas.Business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.LoginRequestDTO;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

   void enviarEmail(@RequestBody TarefasDTOResponse dto);


}
