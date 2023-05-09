package br.com.cadastros.cadastrausuario.application.usuario.application.service;

import br.com.cadastros.cadastrausuario.application.usuario.application.api.*;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
    void deleteUsuarioAtravesCPF(String cpf);
    void patchUsuario(String cpf, UsuarioModificaRequest usuarioModificaRequest);
    UsuarioListDTO buscaUsuarioCPF(String cpf);
}
