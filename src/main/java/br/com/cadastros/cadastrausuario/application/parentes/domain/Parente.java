package br.com.cadastros.cadastrausuario.application.parentes.domain;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteModificaRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Parente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idParente;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    public Parente(ParenteRequest parenteRequest) {
        this.nome = parenteRequest.getNome();
        this.sobrenome = parenteRequest.getSobrenome();
    }
    public void altera(ParenteModificaRequest parenteModificaRequest) {
        this.sobrenome = parenteModificaRequest.getSobrenome();
    }
}
