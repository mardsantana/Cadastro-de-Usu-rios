package br.com.cadastros.cadastrausuario.application.repository;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    List<Usuario> buscaUsuarios();
    Usuario buscarUsuarioPorCpf(String cpf);
    void deleteUsuario(Usuario usuario);
}
