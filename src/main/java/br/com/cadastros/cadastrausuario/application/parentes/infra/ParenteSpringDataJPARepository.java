package br.com.cadastros.cadastrausuario.application.parentes.infra;

import br.com.cadastros.cadastrausuario.application.domain.Parente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParenteSpringDataJPARepository extends JpaRepository<Parente, UUID> {
    Parente save(Parente parente);
}
