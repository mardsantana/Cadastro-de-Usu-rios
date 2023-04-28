package br.com.cadastros.cadastrausuario.application.api;

import br.com.cadastros.cadastrausuario.application.domain.Usuario;
import lombok.Value;

import java.util.List;

@Value
public class UsuariosListResponse {
    private List<UsuarioListDTO> usuarios;
    public static UsuariosListResponse converte(List<Usuario> usuarios) {
        return new UsuariosListResponse(UsuarioListDTO.converte(usuarios));
    }
}
