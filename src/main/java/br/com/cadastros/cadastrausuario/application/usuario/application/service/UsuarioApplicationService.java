package br.com.cadastros.cadastrausuario.application.usuario.application.service;

import br.com.cadastros.cadastrausuario.application.usuario.application.api.*;
import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.usuario.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioApplicationService - criaUsuario");
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioRequest));
        log.info("[finish] UsuarioApplicationService - criaUsuario");
        return UsuarioResponse.builder().idUsuario(usuario.getIdUsuario()).build();
    }
    @Override
    public void deleteUsuarioAtravesCPF(String cpf) {
        log.info("[start] UsuarioApplicationService - deleteUsuarioAtravesCPF");
        Usuario usuario = usuarioRepository.buscarUsuarioPorCpf(cpf);
        usuarioRepository.deleteUsuario(usuario);
        log.info("[start] UsuarioApplicationService - deleteUsuarioAtravesCPF");
    }
    @Override
    public void patchUsuario(String cpf, UsuarioModificaRequest usuarioModificaRequest) {
        log.info("[start] UsuarioApplicationService - patchUsuario");
        Usuario usuario = usuarioRepository.buscarUsuarioPorCpf(cpf);
        usuario.modifica(usuarioModificaRequest);
        usuarioRepository.save(usuario);
        log.info("[finish] UsuarioApplicationService - patchUsuario");
    }

    @Override
    public UsuarioListDTO buscaUsuarioCPF(String cpf) {
        Usuario usuario = usuarioRepository.buscaPorCPF(cpf);
        return new UsuarioListDTO(usuario);
    }
}
