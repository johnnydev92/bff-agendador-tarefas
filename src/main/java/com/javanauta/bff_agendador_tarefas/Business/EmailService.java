package com.javanauta.bff_agendador_tarefas.Business;


import com.javanauta.bff_agendador_tarefas.Business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.Infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {

        emailClient.enviarEmail(dto);
    }

}
