package br.com.cadastros.cadastrausuario.application.usuario.infra;

import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioSpringDataJPARepository extends JpaRepository<Usuario, UUID> {
    Optional<Object> findByCpf(String cpf);
    Usuario findByCpfUsuario(String cpf);
}
