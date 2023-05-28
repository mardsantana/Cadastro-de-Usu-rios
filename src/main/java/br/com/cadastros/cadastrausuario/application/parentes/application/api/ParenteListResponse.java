package br.com.cadastros.cadastrausuario.application.parentes.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import br.com.cadastros.cadastrausuario.application.usuario.application.api.UsuarioListDTO;
import lombok.Value;

import java.util.List;

@Value
public class ParenteListResponse {
    private List<Parente> parentes;
}
