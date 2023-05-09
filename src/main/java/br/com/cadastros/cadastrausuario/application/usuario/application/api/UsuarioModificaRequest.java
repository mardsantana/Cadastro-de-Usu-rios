package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class UsuarioModificaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    private String endereco;
    private List<ParenteRequest> parentes;
}
