package br.com.cadastros.cadastrausuario.application.parentes.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ParenteResponse {
    private UUID idParente;
}