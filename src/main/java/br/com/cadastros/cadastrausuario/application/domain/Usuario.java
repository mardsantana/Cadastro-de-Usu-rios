package br.com.cadastros.cadastrausuario.application.domain;

import br.com.cadastros.cadastrausuario.application.api.UsuarioModificaRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuariosListResponse;
import br.com.cadastros.cadastrausuario.application.parentes.domain.parentes.Parentes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
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
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parentes> parentes = new ArrayList<>();

    public Usuario(){

    }
    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.sobrenome = usuarioRequest.getSobrenome();
        this.cpf = usuarioRequest.getCpf();
        this.endereco = usuarioRequest.getEndereco();
    }
    public Usuario(UUID idUsuario, String nome, String cpf, String sobrenome, String endereco) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    public void UsuariosGerais(UsuariosListResponse usuariosListResponse) {
        this.nome = usuariosListResponse.getNome();
        this.sobrenome = usuariosListResponse.getSobrenome();
        this.cpf = usuariosListResponse.getCpf();
        this.endereco = usuariosListResponse.getEndereco();
        this.parentes = new ArrayList<>();
    }
    public void modifica(UsuarioModificaRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.sobrenome = usuarioRequest.getSobrenome();
        this.endereco = usuarioRequest.getEndereco();
    }
}
