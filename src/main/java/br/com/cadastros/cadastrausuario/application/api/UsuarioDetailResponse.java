package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioDetailResponse {

    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;

    public UsuarioDetailResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
    }

    public UsuarioDetailResponse(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.idUsuario = null;
        this.sobrenome = "";
        this.endereco = "";
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return new Usuario(this.idUsuario, this.nome, this.sobrenome, cpf, this.endereco);
    }

}
