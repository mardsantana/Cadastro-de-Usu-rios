package br.com.cadastros.cadastrausuario.application.parentes.service;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteRequest;

import java.util.List;
import java.util.UUID;

public interface ParenteService {
    ParenteResponse criaParente(ParenteRequest parenteRequest);
    List<Parente> buscaParentesPorUsuario(UUID idUsuario);
}
