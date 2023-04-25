package br.com.cadastros.cadastrausuario.application.parentes.domain.parentes;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import br.com.cadastros.cadastrausuario.application.parentes.api.ParentesRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Parentes {
    @Id
    private UUID idParentes;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    @Column(nullable = false)
    private String grauParentesco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Parentes(String cpf, ParentesRequest parentesRequest) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.grauParentesco = grauParentesco;
        this.usuario = usuario;
    }
}
