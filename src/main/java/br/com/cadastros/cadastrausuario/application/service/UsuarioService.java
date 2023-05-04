package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.*;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
    List<UsuarioListDTO> buscaUsuarios();
    UsuarioDetailResponse buscarUsuarioPorCpf(String cpf);
    void deleteUsuarioAtravesCPF(String cpf);
    void patchUsuario(String cpf, UsuarioModificaRequest usuarioModificaRequest);
}
