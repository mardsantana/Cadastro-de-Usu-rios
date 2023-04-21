package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioResponse postUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest){
       log.info("[start] UsuarioController - postUsuario");
       UsuarioResponse usuarioCriado = usuarioService.criaUsuario(usuarioRequest);
       log.info("[finish] UsuarioController - postUsuario");
       return usuarioCriado;
    }
}
