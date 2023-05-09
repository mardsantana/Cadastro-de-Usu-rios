package br.com.cadastros.cadastrausuario.application.parentes.application.repository;


import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;

import java.util.List;
import java.util.UUID;

public interface ParenteRepository {
    Parente save(Parente parente);
    List<Parente> buscaParentesPorUsuario(UUID idUsuario);
}
