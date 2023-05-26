package br.com.cadastros.cadastrausuario.application.usuario.domain;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import br.com.cadastros.cadastrausuario.application.usuario.application.api.UsuarioModificaRequest;
import br.com.cadastros.cadastrausuario.application.usuario.application.api.UsuarioRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parente> parentes;

    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.sobrenome = usuarioRequest.getSobrenome();
        this.cpf = usuarioRequest.getCpf();
        this.endereco = usuarioRequest.getEndereco();
        this.parentes = usuarioRequest.getParentes()
                .stream().map(Parente::new)
                .collect(Collectors.toList());
    }
    public void modifica(UsuarioModificaRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.sobrenome = usuarioRequest.getSobrenome();
        this.endereco = usuarioRequest.getEndereco();
    }
}
