package com.javanauta.bff_agendador_tarefas.Business;


import com.javanauta.bff_agendador_tarefas.Business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.Infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {

        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo
            (LocalDateTime dataInicial,
             LocalDateTime dataFinal,
             String token) {

        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);

    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {

        return tarefasClient.buscaTarefasPorEmail(token);

    }

    public void deletaTarefasPorId(String id, String token) {

        tarefasClient.deletaTarefaPorId(id, token);

    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {

        return tarefasClient.alteraStatusNotificacao(status, id, token);

    }

    public TarefasDTOResponse updateDeTarefas(TarefasDTORequest dto, String id, String token) {

        return tarefasClient.updateTarefas(dto, id, token);

    }
}
