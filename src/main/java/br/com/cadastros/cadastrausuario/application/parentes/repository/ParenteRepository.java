package br.com.cadastros.cadastrausuario.application.parentes.repository;


import br.com.cadastros.cadastrausuario.application.domain.Parente;

import java.util.List;
import java.util.UUID;

public interface ParenteRepository {
    Parente save(Parente parente);
    List<Parente> findByidUsuario(UUID idUsuario);
}
