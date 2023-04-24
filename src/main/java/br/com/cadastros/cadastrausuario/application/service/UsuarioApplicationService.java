package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.*;
import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.repository.UsuarioRepository;
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
    public List<UsuariosListResponse> buscaUsuarios() {
        log.info("[start] UsuarioApplicationService - buscaUsuarios");
        List<Usuario> usuarios = usuarioRepository.buscaUsuarios();
        log.info("[finish] UsuarioApplicationService - buscaUsuarios");
        return UsuariosListResponse.converte(usuarios);
    }
    @Override
    public UsuarioDetailResponse buscarUsuarioPorCpf(String cpf) {
        log.info("[start] UsarioApplicationService - buscarUsuarioPorCpf");
        Usuario usuario = usuarioRepository.buscarUsuarioPorCpf(cpf);
        log.info("[finish] UsarioApplicationService - buscarUsuarioPorCpf");
        return new UsuarioDetailResponse(usuario);
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
}
