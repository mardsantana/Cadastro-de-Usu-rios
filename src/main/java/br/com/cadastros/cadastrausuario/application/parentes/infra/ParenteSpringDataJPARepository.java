package br.com.cadastros.cadastrausuario.application.parentes.infra;

import br.com.cadastros.cadastrausuario.application.parentes.domain.Parente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParenteSpringDataJPARepository extends JpaRepository<Parente, UUID> {
    Parente save(Parente parente);
}
