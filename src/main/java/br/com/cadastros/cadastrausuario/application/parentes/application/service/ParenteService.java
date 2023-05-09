package br.com.cadastros.cadastrausuario.application.parentes.application.service;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;

import java.util.List;
import java.util.UUID;

public interface ParenteService {
    ParenteResponse criaParente(ParenteRequest parenteRequest);
    List<Parente> buscaParentesPorUsuario(UUID idUsuario);
}
