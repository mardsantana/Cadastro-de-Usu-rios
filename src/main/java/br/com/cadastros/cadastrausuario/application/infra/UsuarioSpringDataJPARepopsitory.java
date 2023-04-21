package br.com.cadastros.cadastrausuario.application.infra;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioSpringDataJPARepopsitory extends JpaRepository<Usuario, UUID> {
}
