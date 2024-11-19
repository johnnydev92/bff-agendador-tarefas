package com.javanauta.bff_agendador_tarefas.infrastructure.client.config;

import com.javanauta.bff_agendador_tarefas.infrastructure.Exceptions.BusinessException;
import com.javanauta.bff_agendador_tarefas.infrastructure.Exceptions.ConflictException;
import com.javanauta.bff_agendador_tarefas.infrastructure.Exceptions.ResourceNotFoundException;
import com.javanauta.bff_agendador_tarefas.infrastructure.Exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributa já existe");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
