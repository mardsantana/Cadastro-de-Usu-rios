package br.com.cadastros.cadastrausuario.application.domain;

import br.com.cadastros.cadastrausuario.application.parentes.Parentes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Usuario {

    @Id
    private UUID idUsuario;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private String endereco;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parentes> parentes = new ArrayList<>();

}
