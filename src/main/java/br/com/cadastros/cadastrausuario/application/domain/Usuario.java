package br.com.cadastros.cadastrausuario.application.domain;

import br.com.cadastros.cadastrausuario.application.api.ParenteRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioModificaRequest;
import br.com.cadastros.cadastrausuario.application.api.UsuarioRequest;
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
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Parente> parentes = new ArrayList<>();;

    public Usuario(){
    }
    public List<Parente> getParentes() {
        return parentes;
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
    public void modifica(UsuarioModificaRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.sobrenome = usuarioRequest.getSobrenome();
        this.endereco = usuarioRequest.getEndereco();
    }
    public void adicionaParente(ParenteRequest parenteRequest) {
        this.nome = parenteRequest.getNome();
        this.sobrenome = parenteRequest.getSobrenome();
    }

}
