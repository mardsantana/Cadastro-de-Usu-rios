package br.com.cadastros.cadastrausuario.application.parentes.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ParentesRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    @Column(nullable = false)
    private String grauParentesco;
}
