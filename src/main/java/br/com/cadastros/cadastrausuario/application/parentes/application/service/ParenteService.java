package br.com.cadastros.cadastrausuario.application.parentes.application.service;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteModificaRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ParenteService {
//    ParenteResponse criaParente(ParenteRequest parenteRequest);
    void deletaParentePorCPFDeUsuario(String cpf, UUID idParente);
    void alteraParenteDoUsuarioPorCPF(String cpf, UUID idParente, @Valid ParenteModificaRequest parenteAlteracaoRequest);
}
