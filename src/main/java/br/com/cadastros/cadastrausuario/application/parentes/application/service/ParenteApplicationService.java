package br.com.cadastros.cadastrausuario.application.parentes.application.service;

import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteRequest;
import br.com.cadastros.cadastrausuario.application.parentes.application.api.ParenteResponse;
import br.com.cadastros.cadastrausuario.application.parentes.application.repository.ParenteRepository;
import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import br.com.cadastros.cadastrausuario.application.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ParenteApplicationService implements ParenteService{
    private final ParenteRepository parenteRepository;
    private final UsuarioService usuarioService;
    @Override
    public ParenteResponse criaParente(ParenteRequest parenteRequest) {
        log.info("[start] UsuarioApplicationService - criaParente");
        Parente parente = parenteRepository.save(new Parente(parenteRequest));
        log.info("[finish] UsuarioApplicationService - criaParente");
        return ParenteResponse.builder().idParente(parente.getIdParente()).build();
    }
    @Override
    public List<Parente> buscaParentesPorUsuario(UUID idUsuario) {
        log.info("[start] ParenteApplicationService - buscaParentesPorUsuario");
        List<Parente> parentes = parenteRepository.buscaParentesPorUsuario(idUsuario);
        log.info("[finish] ParenteApplicationService - buscaParentesPorUsuario");
        return parentes;
    }

    @Override
    public void deletaParentePorCPFDeUsuario(String cpf, UUID idParente) {
        log.info("[start] ParenteApplicationService - deletaParentePorCPFDeUusario");
        usuarioService.buscaUsuarioCPF(cpf);
        Parente parente = parenteRepository.buscaParentePorID(idParente);
        parenteRepository.deletaParente(parente);
        log.info("[finish] ParenteApplicationService - deletaParentePorCPFDeUusario");
    }
}
