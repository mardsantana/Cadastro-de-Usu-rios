package br.com.cadastros.cadastrausuario.application.usuario.application.api;

import br.com.cadastros.cadastrausuario.application.usuario.domain.Usuario;
import lombok.Value;

import java.util.List;

@Value
public class UsuariosListResponse {
    private List<UsuarioListDTO> usuarios;
}
