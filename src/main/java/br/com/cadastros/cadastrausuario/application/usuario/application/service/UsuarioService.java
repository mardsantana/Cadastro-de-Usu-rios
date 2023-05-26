package br.com.cadastros.cadastrausuario.application.usuario.application.service;

import br.com.cadastros.cadastrausuario.application.usuario.application.api.*;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
    void deleteUsuarioAtravesCPF(String cpf);
    void patchUsuario(String cpf, UsuarioModificaRequest usuarioModificaRequest);
    UsuarioListDTO buscaUsuarioCPF(String cpf);
    List<UsuarioListDTO> buscaUsuariosGerais();
}
