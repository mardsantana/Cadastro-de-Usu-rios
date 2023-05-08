package br.com.cadastros.cadastrausuario.application.parentes.api;

import br.com.cadastros.cadastrausuario.application.api.UsuarioListDTO;
import br.com.cadastros.cadastrausuario.application.domain.Parente;
import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ParenteListDTO {
    private UUID idParente;
    private String nome;
    private String sobrenome;
    private String parentesco;
    private List<ParenteRequest> parentes;

    public ParenteListDTO(UUID idParente, String nome, String sobrenome, String parentesco, UsuarioListDTO.ParenteDTO converte) {
        this.idParente = idParente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.parentesco = parentesco;
        this.parentes = parentes;
    }

    public static List<ParenteListDTO> converte(List<Parente> parentes) {
        return parentes.stream()
                .map(parente -> new ParenteListDTO(parente.getIdParente(),parente.getNome()
                        ,parente.getSobrenome()
                        ,parente.getParentesco()
                        , UsuarioListDTO.ParenteDTO.converte(parente.getParentes())))
                .collect(Collectors.toList());
    }
}
