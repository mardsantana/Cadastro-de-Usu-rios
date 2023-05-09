package br.com.cadastros.cadastrausuario.application.usuario.application.repository;

import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    Usuario buscarUsuarioPorCpf(String cpf);
    void deleteUsuario(Usuario usuario);
}
