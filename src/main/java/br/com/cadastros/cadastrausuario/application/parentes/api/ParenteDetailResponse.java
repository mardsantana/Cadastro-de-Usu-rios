package br.com.cadastros.cadastrausuario.application.parentes.api;

import lombok.Value;

import java.util.UUID;

@Value
public class ParenteDetailResponse {

    private UUID idParente;
    private String nome;
    private String sobrenome;

    public ParenteDetailResponse(String nome, String cpf) {
        this.nome = getNome();
        this.idParente = getIdParente();
        this.sobrenome = getSobrenome();
    }
}
