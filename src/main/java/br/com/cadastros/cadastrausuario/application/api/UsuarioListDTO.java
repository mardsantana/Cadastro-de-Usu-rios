package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class UsuarioListDTO {
    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private List<Parente> parentes;

    public UsuarioListDTO(UUID idUsuario, String nome, String sobrenome, String cpf, String endereco, List<Parente> parentes) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.parentes = parentes;
    }


    public static List<UsuarioListDTO> converte(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(usuario -> new UsuarioListDTO(usuario.getIdUsuario(),usuario.getNome()
                        ,usuario.getSobrenome()
                        ,usuario.getCpf()
                        ,usuario.getEndereco()
                        ,usuario.getParentes()))
                .collect(Collectors.toList());
    }

    public UsuarioListDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
        this.parentes = usuario.getParentes();
    }
}
