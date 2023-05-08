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
    private List<ParenteListDTO> parentes;

    public UsuarioListDTO(UUID idUsuario, String nome, String sobrenome, String cpf, String endereco, List<ParenteListDTO> parentes) {
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
                        ,ParenteListDTO.converte(usuario.getParentes())))
                .collect(Collectors.toList());
    }
    @Value
    public static class ParenteListDTO {
        private UUID idParente;
        private String nome;
        private String sobrenome;
        private String parentesco;

        public static ParenteListDTO converte(Parente parente) {
            return new ParenteListDTO(parente.getIdParente(), parente.getNome(), parente.getSobrenome(), parente.getParentesco());
        }
        public static List<ParenteListDTO> converte(List<Parente> parentes) {
            return parentes.stream()
                    .map(ParenteListDTO::converte)
                    .collect(Collectors.toList());
        }
    }
}
