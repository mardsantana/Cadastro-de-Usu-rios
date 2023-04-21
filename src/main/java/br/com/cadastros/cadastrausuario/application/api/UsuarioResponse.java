package br.com.cadastros.cadastrausuario.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class UsuarioResponse {
    private UUID idUsuario;;
}
