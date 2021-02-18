package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroComparatorVO {
    private String name;
    private String attribute;
    private int diference;

    public HeroComparatorVO(String name, String attribute, int diference) {
        this.name = name;
        this.attribute = attribute;
        this.diference = diference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getDiference() {
        return diference;
    }

    public void setDiference(int diference) {
        this.diference = diference;
    }

    public static List<HeroComparatorVO> getListComparator(Hero hero1, Hero hero2) {
        List<HeroComparatorVO> lstComp = new ArrayList<>();
        PowerStats ps1 = hero1.getPowerStats();
        PowerStats ps2 = hero2.getPowerStats();
        lstComp.add(new HeroComparatorVO(hero1.getName(), "Agilidade", ps1.getAgility() - ps2.getAgility()));
        lstComp.add(new HeroComparatorVO(hero1.getName(),"Força", ps1.getStrength() - ps2.getStrength()));
        lstComp.add(new HeroComparatorVO(hero1.getName(),"Destreza", ps1.getDexterity() - ps2.getDexterity()));
        lstComp.add(new HeroComparatorVO(hero1.getName(),"Inteligência", ps1.getIntelligence() - ps2.getIntelligence()));
        return lstComp;
    }

}
