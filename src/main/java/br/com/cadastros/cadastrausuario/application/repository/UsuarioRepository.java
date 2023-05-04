package br.com.cadastros.cadastrausuario.application.repository;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    List<Usuario> buscaUsuarios();
    Usuario buscarUsuarioPorCpf(String cpf);
    void deleteUsuario(Usuario usuario);
}
