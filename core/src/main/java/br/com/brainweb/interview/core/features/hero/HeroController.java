package br.com.brainweb.interview.core.features.hero;


import br.com.brainweb.interview.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    public HeroService heroService;

    @GetMapping
    public List<Hero> all() {
        return heroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        Hero hero = heroService.getById(id);
        if (hero != null) {
            return ResponseEntity.ok(hero);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/byFilter")
    public ResponseEntity getByFilter(@RequestBody HeroFilter filter) {
        try {
            List<Hero> lst = heroService.getByFilter(filter);
            if (!lst.isEmpty()) {
                return ResponseEntity.ok(lst);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity newHero(@RequestBody Hero hero) {
        try {
            heroService.save(hero);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity updateHero(@RequestBody Hero hero) {
        try {
            heroService.update(hero);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHero(@PathVariable UUID id) {
        try {
            heroService.delete(id);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("compareTwoHeros/{id1}/{id2}")
    public ResponseEntity compareTwoHeros(@PathVariable UUID id1, @PathVariable UUID id2) {
        try {
            List lst = heroService.compareTwoHeroes(id1, id2);
            return ResponseEntity.ok(lst);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
