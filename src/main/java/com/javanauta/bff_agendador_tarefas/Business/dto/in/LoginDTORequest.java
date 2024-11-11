package com.javanauta.bff_agendador_tarefas.Business.dto.in;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTORequest {

    private String email;
    private String senha;
}
