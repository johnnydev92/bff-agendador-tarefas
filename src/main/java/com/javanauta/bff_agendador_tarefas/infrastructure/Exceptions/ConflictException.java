package com.javanauta.bff_agendador_tarefas.infrastructure.Exceptions;

public class ConflictException extends RuntimeException {

    public  ConflictException(String mensagem){
        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
