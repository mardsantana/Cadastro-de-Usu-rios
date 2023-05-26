package br.com.cadastros.cadastrausuario.application.usuario.infra;

import br.com.cadastros.cadastrausuario.application.handler.APIException;
import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.usuario.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;

    @Override
    public Usuario save(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - save");
        try {
            usuarioSpringDataJPARepository.save(usuario);
        } catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
        }
        log.info("[finsih] UsuarioInfraRepository - save");
        return usuario;
    }
    @Override
    public Usuario buscarUsuarioPorCpf(String cpf) {
        log.info("[start] UsuarioInfraRepository - buscarUsuarioPorCpf");
        Usuario usuario = (Usuario) usuarioSpringDataJPARepository.findByCpf(cpf)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não Encontrado"));
        log.info("[start] UsuarioInfraRepository - buscarUsuarioPorCpf");
        return usuario;
    }
    @Override
    public void deleteUsuario(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - deleteUsuario");
        usuarioSpringDataJPARepository.delete(usuario);
        log.info("[finish] UsuarioInfraRepository - deleteUsuario");
    }
    @Override
    public List<Usuario> buscaUsuariosGerais() {
        log.info("[start] UsuarioInfraRepository - buscaUsuariosGerais");
        List<Usuario> usuariosGerais = usuarioSpringDataJPARepository.findAll();
        log.info("[finish] UsuarioInfraRepository - buscaUsuariosGerais");
        return usuariosGerais;
    }
}
