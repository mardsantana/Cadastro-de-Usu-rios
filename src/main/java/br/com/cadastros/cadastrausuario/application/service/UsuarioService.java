package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.*;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
    List<UsuariosListResponse> buscaUsuarios();
    UsuarioDetailResponse buscarUsuarioPorCpf(String cpf);
    void deleteUsuarioAtravesCPF(String cpf);
    void patchUsuario(String cpf, UsuarioModificaRequest usuarioModificaRequest);
}
