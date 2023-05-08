package br.com.cadastros.cadastrausuario.application.domain;

import br.com.cadastros.cadastrausuario.application.parentes.api.ParenteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Parente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idParente;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String parentesco;

    public Parente(){

    }
    public Parente(String nome, String sobrenome, String parentesco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.parentesco = parentesco;
    }
    public Parente(ParenteRequest parenteRequest) {
        this.nome = parenteRequest.getNome();
        this.sobrenome = parenteRequest.getSobrenome();
        this.parentesco = parenteRequest.getParentesco();
    }

    public Parente getParentes() {
        return null;
    }
}
