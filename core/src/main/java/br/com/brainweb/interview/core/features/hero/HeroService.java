package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeroService {

    @Autowired
    public HeroRepository heroRepository;

    public List<Hero> findAll(){
        return heroRepository.findAll();
    }

    public Hero getById(UUID id) {
        return heroRepository.getOne(id);
    }

    public void save(Hero hero) {
        hero.setCreatedAt(Calendar.getInstance().getTime());
        hero.setUpdatedAt(Calendar.getInstance().getTime());
        heroRepository.save(hero);
    }

    public void delete(UUID id) {
        heroRepository.deleteById(id);
    }

    public void update(Hero up) throws Exception {
        List<Hero> lst = getByFilter(new HeroFilter(up.getName()));
        if (lst.isEmpty()) {
            throw new Exception("Heroi não encontrado!");
        } else {
            Hero hero = lst.get(0);
            if (up.getPowerStatsId() != null) {
                hero.setPowerStats(new PowerStats(up.getPowerStatsId()));
            }
            if (up.getRace() != null) {
                hero.setRace(up.getRace());
            }
            hero.setUpdatedAt(Calendar.getInstance().getTime());
            heroRepository.saveAndFlush(hero);
        }
    }

    public List<Hero> getByFilter(HeroFilter filter){
        Hero hero = new Hero();
        hero.setName(filter.getName());
        return heroRepository.findAll(Example.of(hero));
    }

    public List<HeroComparatorVO> compareTwoHeroes(UUID id1, UUID id2) throws Exception {
        Hero hero1 = heroRepository.getOne(id1);
        Hero hero2 = heroRepository.getOne(id2);
        if (hero1 == null || hero2 == null) {
            throw new Exception("Não é possivel a comparação!");
        }
        List<HeroComparatorVO> lst = HeroComparatorVO.getListComparator(hero1, hero2);
        lst.addAll(HeroComparatorVO.getListComparator(hero2, hero1));
        return lst;
    }
}
