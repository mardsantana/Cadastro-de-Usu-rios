package br.com.cadastros.cadastrausuario.application.parentes.service;

import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParentesRequest;

public interface ParentesService {
    ParenteResponse criaParentes(String cpf, ParentesRequest parentesRequest);
}
