package com.javanauta.bff_agendador_tarefas.Business.dto.in;


import com.javanauta.bff_agendador_tarefas.Business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {


    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataEvento;

}
