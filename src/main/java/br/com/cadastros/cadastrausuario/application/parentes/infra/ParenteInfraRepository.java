package br.com.cadastros.cadastrausuario.application.parentes.infra;

import br.com.cadastros.cadastrausuario.application.handler.APIException;
import br.com.cadastros.cadastrausuario.application.parentes.application.repository.ParenteRepository;
import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ParenteInfraRepository implements ParenteRepository {
    private final ParenteSpringDataJPARepository parenteSpringDataJPARepository;
    @Override
    public Parente save(Parente parente) {
        log.info("[start] UsuarioInfraRepository - saveP");
        parenteSpringDataJPARepository.save(parente);
        log.info("[finish] UsuarioInfraRepository - saveP");
        return parente;
    }
    @Override
    public List<Parente> buscaParentesPorUsuario(UUID idUsuario) {
        log.info("[start] ParenteInfraRepository - buscaParentesPorUsuario");
        List<Parente> listaParentes = parenteSpringDataJPARepository.findParenteByIdUsuario(idUsuario);
        log.info("[finish] ParenteInfraRepository - buscaParentesPorUsuario");
        return listaParentes;
    }
    @Override
    public Parente buscaParentePorID(UUID idParente) {
        log.info("[start] ParenteInfraRepository - buscaParentePorID");
        var parente = parenteSpringDataJPARepository.findById(idParente).orElseThrow(
                () -> APIException.build(HttpStatus.NOT_FOUND, "Parente Não encontrado para o idParente = " + idParente));
        log.info("[finish] ParenteInfraRepository - buscaParentePorID");
        return parente;
    }
    @Override
    public void deletaParente(Parente parente) {
        log.info("[start] ParenteInfraRepository - deletaParente");
        parenteSpringDataJPARepository.delete(parente);
        log.info("[finish] ParenteInfraRepository - deletaParente");
    }
}
