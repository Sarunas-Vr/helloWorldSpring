package com.helloworld.demo.repository;

import com.helloworld.demo.Controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/*
    O kas, jeigu nenorime rupintis paprastomis uzklausomis, juk jos visada vienodos.
    Mes nenorime isradineti dviracio.
    Spring Data JPA repository leidzia:
        - Atsisakyti paprastu uzklausu;
        - lengviau rasyti vidutinio sudetingumo uzklausas;
        - Visiskai nekurti repository klases.
    CRUD igyvendinantis DAO su Spring Data atrodo taip (zr. 28 kodo eilute)
        - Nereikia jokios implementacijos!
        - Jei kitoje klaseje pasiimsime su Autowired, galesime kviesti ivairius metodys, pvz.:
            - userRepository.save(user); Create/ Update
            - userRepository.findAll(); Read
            - userRepository.delete(user); Delete
            - ir kt.
    Galima susikurti bet kokius metodus, sujungiant operacijos pavadinima (pvz delete),
        tuomet tai, ka norime rasti, pvz User, zodi by bei reikalingus laukus.
     Galimos operacijos:
        find, read, query, count, get, delete, exists
        Neirasius ieskomojo, bus pasirinkta is interfeiso.
        Galima patikslinti, ko tiksliau ieskome:
            findFirst.., findTop.., findDistinct.., findUser.., findFirstUser.., findDistinctUser..
*/
public interface RoleRepository extends JpaRepository<User, Long> {
}
