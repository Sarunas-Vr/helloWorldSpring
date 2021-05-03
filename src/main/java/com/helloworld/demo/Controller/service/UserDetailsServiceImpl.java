package com.helloworld.demo.Controller.service;


import com.helloworld.demo.Controller.model.Role;
import com.helloworld.demo.Controller.model.User;
import com.helloworld.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

// UserDetailsService skirtas gauti su vartotoju susijusia informacija
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    /*
        @Transactional anotacija skirta visoms neatsiejamoms operacijoms valdyti.
        Metodai, kuriu veiksmai vykdomi transakcijose pazymimi @Transactional
        Transakcija yra butina visiems metodams dirbantiems su duomenu baze
        @Transactional prades transakcija tik jei komponentas sukurtas per Spring ir kviecianas is kitos klases
    */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw  new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // Perziurimos esamos vartotoju roles (saugomos db 'role' lenteleje)
        // ir priskiriamos esamam vartotojui (saugoma 'user_roles' lenteleje)
        // Tarkime, jeigu 'role' lenteleje yra dvi roles (user, admin), tai esamas vartotojas jas abi ir gaus
        for(Role role: user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
