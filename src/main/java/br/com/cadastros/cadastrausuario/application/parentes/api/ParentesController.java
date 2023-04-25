package br.com.cadastros.cadastrausuario.application.parentes.api;

import br.com.cadastros.cadastrausuario.application.parentes.service.ParentesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("usuario/{cpf}/parentes")
@RequiredArgsConstructor
public class ParentesController {
    private final ParentesService parentesService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParenteResponse postParentes(@PathVariable String cpf, @Valid @RequestBody ParentesRequest parentesRequest ){
        log.info("[start] ParentesController - postParentes");
        log.info("[cpf]{}", cpf);
        ParenteResponse parentes = parentesService.criaParentes(cpf, parentesRequest);
        log.info("[finish] ParentesController - postParentes");
        return parentes;
    }
}
