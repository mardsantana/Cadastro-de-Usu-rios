package br.com.cadastros.cadastrausuario.application.parentes.infra;

import br.com.cadastros.cadastrausuario.application.parentes.application.repository.ParenteRepository;
import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        List<Parente> listaParentes = parenteSpringDataJPARepository.findParenteByIdUsuario(idUsuario);
        return listaParentes;
    }

}
