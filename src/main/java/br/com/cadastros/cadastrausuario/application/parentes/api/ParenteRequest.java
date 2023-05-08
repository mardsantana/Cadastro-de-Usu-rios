package br.com.cadastros.cadastrausuario.application.parentes.api;


import jakarta.validation.constraints.NotBlank;
import lombok.Value;;

@Value
public class ParenteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String parentesco;
}
