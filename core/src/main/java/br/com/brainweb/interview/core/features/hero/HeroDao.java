package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HeroDao extends JpaRepository<Hero, UUID> {
}
