package br.com.cadastros.cadastrausuario.application.parentes.application.api;


import jakarta.validation.constraints.NotBlank;
import lombok.Value;import java.util.UUID;

@Value
public class ParenteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String parentesco;
    private UUID idUsuario;
}
