package br.com.cadastros.cadastrausuario.application.parentes.api;

import br.com.cadastros.cadastrausuario.application.api.UsuarioListDTO;
import br.com.cadastros.cadastrausuario.application.domain.Parente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ParenteListResponse {
    private List<Parente> parentes;

    public static UsuarioListDTO.ParenteListDTO converte(Parente parente) {
        return new UsuarioListDTO.ParenteListDTO(parente.getIdParente(), parente.getNome(), parente.getSobrenome(), parente.getParentesco());
    }
}
