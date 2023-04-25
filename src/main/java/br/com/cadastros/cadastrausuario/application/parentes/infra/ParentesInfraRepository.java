package br.com.cadastros.cadastrausuario.application.parentes.infra;

import br.com.cadastros.cadastrausuario.application.parentes.domain.parentes.Parentes;
import br.com.cadastros.cadastrausuario.application.parentes.parentesSpringDataJPARepository.ParentesSpringDataJPARepository;
import br.com.cadastros.cadastrausuario.application.parentes.service.ParentesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ParentesInfraRepository implements ParentesRepository {
    private final ParentesSpringDataJPARepository parentesSpringDataJPARepository;
    @Override
    public Parentes saveParentes(Parentes parentes) {
        log.info("[start] ParentesInfraRepository - saveParentes");
        parentesSpringDataJPARepository.save(parentes);
        log.info("[finish] ParentesInfraRepository - saveParentes");
        return parentes;
    }
}
