package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
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
    @Valid
    private List<Parente> parentes;
}
