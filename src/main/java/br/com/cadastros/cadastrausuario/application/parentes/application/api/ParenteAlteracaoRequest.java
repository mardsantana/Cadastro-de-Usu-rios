package br.com.cadastros.cadastrausuario.application.parentes.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ParenteAlteracaoRequest {
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String parentesco;
}
