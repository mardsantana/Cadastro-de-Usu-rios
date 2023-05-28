package br.com.cadastros.cadastrausuario.application.parentes.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.application.service.ParenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/parentes")
@RequiredArgsConstructor
public class ParenteController {
    private final ParenteService parenteService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParenteResponse postParente(@Valid @RequestBody ParenteRequest parenteRequest) {
        log.info("[start] UsuarioController - postParente");
        ParenteResponse parenteCriado = parenteService.criaParente(parenteRequest);
        log.info("[finish] UsuarioController - postParente");
        return parenteCriado;
    }
    @DeleteMapping(value = "/{cpf}/{idParente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteParentePorCPFUsuario(@PathVariable String cpf, @PathVariable UUID idParente){
        log.info("[start] ParenteController - deliteParentePorCPFUsuario");
        log.info("[cpf]{} - [idParente]{}", cpf, idParente);
        parenteService.deletaParentePorCPFDeUsuario(cpf, idParente);
        log.info("[finish] ParenteController - deliteParentePorCPFUsuario");
    }
    @PatchMapping(value = "/{cpf}/{idParente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchParente(@PathVariable String cpf, @PathVariable UUID idParente,
                      @Valid @RequestBody ParenteModificaRequest parenteModificaRequest){
        log.info("[start] ParenteController - patchParente");
        log.info("[cpf]{} - [idParente]{}", cpf, idParente);
        parenteService.alteraParenteDoUsuarioPorCPF(cpf, idParente, parenteModificaRequest);
        log.info("[finish] ParenteController - patchParente");
    }
}
