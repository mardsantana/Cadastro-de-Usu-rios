package br.com.cadastros.cadastrausuario.application.parentes.api;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("usuario/{cpf}/parentes")
public class ParentesController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParenteResponse postParentes(@PathVariable String cpf, @Valid @RequestBody ParentesRequest parentesRequest ){
        log.info("[start] ParentesController - postParentes");
        log.info("[finish] ParentesController - postParentes");
        return null;
    }
}
