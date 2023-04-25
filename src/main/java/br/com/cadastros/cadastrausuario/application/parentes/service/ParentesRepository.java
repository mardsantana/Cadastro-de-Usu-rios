package br.com.cadastros.cadastrausuario.application.parentes.service;

import br.com.cadastros.cadastrausuario.application.parentes.domain.parentes.Parentes;

public interface ParentesRepository {
    Parentes saveParentes(Parentes parentes);
}
