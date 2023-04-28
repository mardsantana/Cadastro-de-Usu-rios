package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ParenteListResponse {
    private UUID idParente;
    private String nome;
    private String sobrenome;
    private String parentesco;
    private List<ParenteRequest> parentes;

    public static List<ParenteListResponse> converte(List<Parente> parentes) {
        return parentes.stream()
                .map((Parente parenteRequest) -> new ParenteListResponse(parenteRequest, parentes))
                .collect(Collectors.toList());
    }
    public ParenteListResponse(Parente parenteRequest, List<Parente> parentes) {
        this.idParente = getIdParente();
        this.nome = getNome();
        this.sobrenome = getSobrenome();
        this.parentesco = getParentesco();
        this.parentes = getParentes();
    }
}
