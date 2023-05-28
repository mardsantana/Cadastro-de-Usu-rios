package br.com.cadastros.cadastrausuario.application.parentes.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Value
public class ParenteListDTO {
    private UUID idParente;
    private String nome;
    private String sobrenome;

    public ParenteListDTO(Parente parente) {
        this.idParente = parente.getIdParente();
        this.nome = parente.getNome();
        this.sobrenome = parente.getSobrenome();
    }
    public static List<ParenteListDTO> parseToList(List<Parente> parentesDoUsuario) {
        return parentesDoUsuario.stream()
                .map(ParenteListDTO::new)
                .collect(Collectors.toList());
    }
}
