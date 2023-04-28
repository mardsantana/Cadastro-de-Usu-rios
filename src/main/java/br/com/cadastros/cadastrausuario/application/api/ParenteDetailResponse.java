package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class ParenteDetailResponse {

    private UUID idParente;
    private String nome;
    private String sobrenome;

    public ParenteDetailResponse(Usuario usuario) {
        this.idParente = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
    }
    public ParenteDetailResponse(String nome, String cpf) {
        this.nome = nome;
        this.idParente = null;
        this.sobrenome = "";
    }
}
