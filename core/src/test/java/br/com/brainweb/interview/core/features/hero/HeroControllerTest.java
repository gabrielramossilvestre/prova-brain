package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HeroControllerTest {

    @Autowired
    private HeroController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void listAll() throws Exception {
        assertThat(controller.all()).isNotNull();
    }

    @Test
    public void createHero() {
        Hero hero = new Hero();
        hero.setPowerStats(new PowerStats(UUID.fromString("8107dc12-c0b0-498e-95a9-1b76df8b85f7")));
        hero.setName("ROBOCOPA");
        hero.setRace(Hero.Race.CYBORG);
        hero.setUpdatedAt(Calendar.getInstance().getTime());
        hero.setCreatedAt(Calendar.getInstance().getTime());
        hero.setEnabled(Boolean.TRUE);
        controller.newHero(hero);
    }

    @Test
    public void updateHero() {
        Hero hero = new Hero();
        hero.setName("PORCO");
        hero.setRace(Hero.Race.DIVINE);
        controller.updateHero(hero);
    }

    @Test
    public void deleteHero() {
        //controller.deleteHero(UUID.fromString("cbd34916-59ec-4e99-9052-28a322e1c746"));
    }
}
