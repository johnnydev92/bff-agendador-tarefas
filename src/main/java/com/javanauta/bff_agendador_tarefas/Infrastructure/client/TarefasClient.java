package com.javanauta.bff_agendador_tarefas.Infrastructure.client;


import com.javanauta.bff_agendador_tarefas.Business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);



    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);


    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("Status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader("Authorization") String token);


    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);


}
