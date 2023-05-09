package br.com.cadastros.cadastrausuario.application.usuario.infra;

import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.usuario.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;

    @Override
    public Usuario save(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - save");
        usuarioSpringDataJPARepository.save(usuario);
        log.info("[finsih] UsuarioInfraRepository - save");
        return usuario;
    }
    @Override
    public Usuario buscarUsuarioPorCpf(String cpf) {
        log.info("[start] UsuarioInfraRepository - buscarUsuarioPorCpf");
        Usuario usuario = (Usuario) usuarioSpringDataJPARepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não Encontrado"));
        log.info("[start] UsuarioInfraRepository - buscarUsuarioPorCpf");
        return usuario;
    }
    @Override
    public void deleteUsuario(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - deleteUsuario");
        usuarioSpringDataJPARepository.delete(usuario);
        log.info("[finish] UsuarioInfraRepository - deleteUsuario");
    }
}
