package com.javanauta.bff_agendador_tarefas.Business;


import com.javanauta.bff_agendador_tarefas.Business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.LoginRequestDTO;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.Business.dto.out.UsuarioDTOResponse;
import com.javanauta.bff_agendador_tarefas.Infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto){

        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){

        return client.buscaUsuarioPorEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email, String token){

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){

        return client.atualizaDadoUsuario(dto, token);

    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){

        return client.atulizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){

        return client.atulizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco (String token, EnderecoDTORequest dto){

        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone (String token, TelefoneDTORequest dto){

        return client.cadastraTelefone(dto, token);
    }
}
