package br.com.cadastros.cadastrausuario.application.parentes;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
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
}
