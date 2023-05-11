package br.com.cadastros.cadastrausuario.application.parentes.domain;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteAlteracaoRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Parente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idParente;
    private UUID idUsuario;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String parentesco;

    public Parente(ParenteRequest parenteRequest) {
        this.nome = parenteRequest.getNome();
        this.sobrenome = parenteRequest.getSobrenome();
        this.parentesco = parenteRequest.getParentesco();
        this.idUsuario = parenteRequest.getIdUsuario();
        this.idParente = UUID.randomUUID();
    }
    public void altera(ParenteAlteracaoRequest parenteAlteracaoRequest) {
        this.sobrenome = parenteAlteracaoRequest.getSobrenome();
        this.parentesco = parenteAlteracaoRequest.getParentesco();
    }
}
