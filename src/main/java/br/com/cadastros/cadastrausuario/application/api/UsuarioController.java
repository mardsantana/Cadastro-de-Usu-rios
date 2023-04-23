package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<UsuariosListResponse> getTodosParentes(){
      log.info("[start] UsuarioController - getTodosUsuarios");
      List<UsuariosListResponse> usuarios = usuarioService.buscaUsuarios();
      log.info("[finish] UsuarioController - getTodosUsuarios");
      return usuarios;
    }

    @GetMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDetailResponse getUsuarioPorCPF(@PathVariable String cpf){
        log.info("[start] UsuarioController - getUsuarioPorCPF");
        log.info("[cpf]{}", cpf);
        UsuarioDetailResponse detailResponse = usuarioService.buscarUsuarioPorCpf(cpf);
        log.info("[finish] UsuarioController - getUsuarioPorCPF");
        return detailResponse;
    }
}
