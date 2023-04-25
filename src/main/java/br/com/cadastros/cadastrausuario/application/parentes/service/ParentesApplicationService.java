package br.com.cadastros.cadastrausuario.application.parentes.service;

import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParentesRequest;
import br.com.cadastros.cadastrausuario.application.parentes.domain.parentes.Parentes;
import br.com.cadastros.cadastrausuario.application.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ParentesApplicationService implements ParentesService{
    private final ParentesRepository parentesRepository;
    private final UsuarioService usuarioService;
    @Override
    public ParenteResponse criaParentes(String cpf, @Valid ParentesRequest parentesRequest) {
        log.info("[start] ParentesApplicationService - criaParentes");
        usuarioService.buscarUsuarioPorCpf(cpf);
        Parentes parentes = parentesRepository.saveParentes(new Parentes(cpf, parentesRequest));
        log.info("[finish] ParentesApplicationService - criaParentes");
        return new ParenteResponse(parentes.getIdParentes());
    }
}
