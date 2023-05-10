package br.com.cadastros.cadastrausuario.application.parentes.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import br.com.cadastros.cadastrausuario.application.parentes.application.service.ParenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/usuario/{idUsuario}")
    List<ParenteListDTO> getParentesDoUsuario(@PathVariable UUID idUsuario) {
        log.info("[start] ParenteController - getParentesDoUsuario");
        List<Parente> parentesDoUsuario = parenteService.buscaParentesPorUsuario(idUsuario);
        log.info("[finish] ParenteController - getParentesDoUsuario");
        return ParenteListDTO.parseToList(parentesDoUsuario);
    }

    //Criar Método para deletar o parente/parentes através do ID do usuário, ou quando o usuário for deletado

}
