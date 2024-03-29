package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.usuario.application.service.UsuarioService;
import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioResponse postUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioController - postUsuario");
        UsuarioResponse usuarioCriado = usuarioService.criaUsuario(usuarioRequest);
        log.info("[finish] UsuarioController - postUsuario");
        return usuarioCriado;
    }
    @GetMapping(value = "/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioListDTO buscaUsuarioCPF(Usuario usuario, String cpf){
        log.info("[start] UsuarioController - buscaUsuarioCPF");
        UsuarioListDTO buscaUsuario = usuarioService.buscaUsuarioCPF(cpf);
        log.info("[finish] UsuarioController - buscaUsuarioCPF");
        return buscaUsuario;
    }
    @DeleteMapping(value = "/{cpf}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteUsuarioAtravesCPF(@PathVariable String cpf) {
        log.info("[start] UsuarioController - deleteUusuarioAtravesCPF");
        log.info("[cpf]{}", cpf);
        usuarioService.deleteUsuarioAtravesCPF(cpf);
        log.info("[finish] UsuarioController - deleteUusuarioAtravesCPF");
    }
    @PatchMapping(value = "/{cpf}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchUsuario(@PathVariable String cpf, @Valid @RequestBody UsuarioModificaRequest usuarioModificaRequest) {
        log.info("[start] UsuarioController - patchUsuario");
        log.info("[cpf]{}", cpf);
        usuarioService.patchUsuario(cpf, usuarioModificaRequest);
        log.info("[finsih] UsuarioController - patchUsuario");
    }
    @GetMapping(value = {"/{cpf}", "/{nome}"})
    @ResponseStatus(code = HttpStatus.OK)
    List<UsuarioListDTO> buscaUsuariosGerais(){
        log.info("[start] UsuarioController - buscaUsuariosGerais");
        List<UsuarioListDTO> usuarios = usuarioService.buscaUsuariosGerais();
        log.info("[finish] UsuarioController - buscaUsuariosGerais");
        return usuarios;
    }

}
