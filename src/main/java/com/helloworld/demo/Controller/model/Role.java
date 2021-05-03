package com.helloworld.demo.Controller.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*
        DAUG-SU-DAUG - tai rysys tarp dvieju lenteliu, kur keletas eiluciu is vienos lenteles gali tureti
        keleta atitinkanciu eiluciu is kitos lenteles. Pvz.: mokykla, kurioje mokytojai mokina mokinius.
        Kiekvienas mokytojas mokina daugeli moksleiviu ir kiekvienas moksleivis yra mokinamas daugelio mokytoju.
        Svarbu pamineti, jog aprasant si rysi tarp lenteliu, yra sukuriama dar viena papildoma (tarpine) lentele,
        kuri apjungia pastarasias. Taigi daug-su-daug rysys susideda is dvieju rysiu vienas-su-daug.
        Siuo atveju sukuriama db tarpine lentele 'user_roles', apjungiant 'user' ir 'roles' lenteles
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
