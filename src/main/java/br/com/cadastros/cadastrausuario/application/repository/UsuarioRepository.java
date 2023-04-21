package br.com.cadastros.cadastrausuario.application.repository;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
}
