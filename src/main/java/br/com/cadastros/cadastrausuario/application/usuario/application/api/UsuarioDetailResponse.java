package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioDetailResponse {

    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private UUID parentes;

    public UsuarioDetailResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
        this.parentes = usuario.getIdUsuario();
    }
}
