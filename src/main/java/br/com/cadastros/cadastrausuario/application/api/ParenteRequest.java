package br.com.cadastros.cadastrausuario.application.api;


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
