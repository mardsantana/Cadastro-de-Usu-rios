package br.com.cadastros.cadastrausuario.application.parentes.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class ParenteModificaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
}
