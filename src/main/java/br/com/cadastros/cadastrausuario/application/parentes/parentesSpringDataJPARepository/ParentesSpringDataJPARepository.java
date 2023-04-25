package br.com.cadastros.cadastrausuario.application.parentes.parentesSpringDataJPARepository;

import br.com.cadastros.cadastrausuario.application.parentes.domain.parentes.Parentes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentesSpringDataJPARepository extends JpaRepository<Parentes, UUID> {
}
