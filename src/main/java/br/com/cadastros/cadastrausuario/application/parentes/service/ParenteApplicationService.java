package br.com.cadastros.cadastrausuario.application.parentes.service;

import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteRequest;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.repository.ParenteRepository;
import br.com.cadastros.cadastrausuario.application.domain.Parente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ParenteApplicationService implements ParenteService{
    private final ParenteRepository parenteRepository;
    @Override
    public ParenteResponse criaParente(ParenteRequest parenteRequest) {
        log.info("[start] UsuarioApplicationService - criaParente");
        Parente parente = parenteRepository.save(new Parente(parenteRequest));
        log.info("[finish] UsuarioApplicationService - criaParente");
        return ParenteResponse.builder().idParente(parente.getIdParente()).build();
    }

    @Override
    public List<Parente> buscaParentesPorUsuario(UUID idUsuario) {
        log.info("[start] ParenteApplicationService - buscaParentesPorUsuario");
        List<Parente> parentes = parenteRepository.findByidUsuario(idUsuario);
        log.info("[finish] ParenteApplicationService - buscaParentesPorUsuario");
        return parentes;
    }
}
