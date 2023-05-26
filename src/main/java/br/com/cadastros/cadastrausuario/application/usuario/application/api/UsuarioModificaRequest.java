package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;


@Value
public class UsuarioModificaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    private String endereco;
}
