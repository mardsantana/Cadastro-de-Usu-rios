package br.com.cadastros.cadastrausuario.application.infra;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepopsitory usuarioSpringDataJPARepopsitory;
    @Override
    public Usuario save(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - save");
        usuarioSpringDataJPARepopsitory.save(usuario);
        log.info("[finsih] UsuarioInfraRepository - save");
        return usuario;
    }
}
