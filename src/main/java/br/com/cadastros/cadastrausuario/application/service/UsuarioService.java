package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.UsuarioDetailResponse;
import br.com.cadastros.cadastrausuario.application.api.UsuarioRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioResponse;
import br.com.cadastros.cadastrausuario.application.api.UsuariosListResponse;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
    List<UsuariosListResponse> buscaUsuarios();
    UsuarioDetailResponse buscarUsuarioPorCpf(String cpf);
    void deleteUsuarioAtravesCPF(String cpf);
}
