package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.UsuarioRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);
}
