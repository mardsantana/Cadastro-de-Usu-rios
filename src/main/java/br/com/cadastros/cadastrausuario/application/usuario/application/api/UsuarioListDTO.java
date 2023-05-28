package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
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

    public UsuarioListDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
        this.parentes = usuario.getParentes();
    }
    public static List<UsuarioListDTO> converte(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioListDTO::new)
                .collect(Collectors.toList());
    }
}
