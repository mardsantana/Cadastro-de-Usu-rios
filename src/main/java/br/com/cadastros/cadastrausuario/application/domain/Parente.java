package br.com.cadastros.cadastrausuario.application.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
