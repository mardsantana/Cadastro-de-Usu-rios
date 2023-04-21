package br.com.cadastros.cadastrausuario.application.service;

import br.com.cadastros.cadastrausuario.application.api.UsuarioRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService{
    @Override
    public UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioApplicationService - criaUsuario");
        log.info("[finish] UsuarioApplicationService - criaUsuario");
        return null;
    }
}
