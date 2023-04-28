package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;


@Value
public class UsuarioRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private String endereco;
    private List<ParenteRequest> parentes;
}
