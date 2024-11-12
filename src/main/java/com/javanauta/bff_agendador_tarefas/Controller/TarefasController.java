package com.javanauta.bff_agendador_tarefas.Controller;



import com.javanauta.bff_agendador_tarefas.Business.TarefasService;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.Infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastro tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salva tarefas de usuarios", description = "Cria um nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));

    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por periodo", description = "Busca tarefas cadastradas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não altorizado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token){

    return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));

    }

    @GetMapping
    @Operation(summary = "Buscalista de tarefas por email de usuario",
            description = "Busca tarefas cadastradas por usuario")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não altorizado")
    @ApiResponse(responseCode = "403", description = "Email não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(
            @RequestHeader(name = "Authorization", required = false) String token){

        List<TarefasDTOResponse> tarefas = tarefasService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por ID", description = "Deleta tarefas cadastradas pro ID")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não altorizado")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token){

        tarefasService.deletaTarefasPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas",
            description = "Altera status de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status da Tarefa alterado com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não altorizado")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(
            @RequestParam("Status") StatusNotificacaoEnum status,
            @RequestParam("id") String id,
            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas",
            description = "Altera dados de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas com sucesso")
    @ApiResponse(responseCode = "401", description = "Usuário não altorizado")
    @ApiResponse(responseCode = "403", description = "Tarefa id não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(tarefasService.updateDeTarefas(dto, id, token));
    }

}
