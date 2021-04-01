package com.helloworld.demo.Controller.service;


import com.helloworld.demo.Controller.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import com.helloworld.demo.Controller.model.Number;
// @Service - servisu sluoksnis biznio logikai
// Po serviso sluoskjniu kreipiames i DAO
@Service
public class NumberServiceImpl implements NumberService {
    // @Autowired - naudojamas automatinei priklausomybiu injekcijai
    // Kad panaudoti "Autowired anotacija, reikia pirmiausia tureti apsirasius @Bean @Configuration klaseje
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai bean susieti priklausomybe.
    // Jeigu @Configuration klaseje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the bean as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    private NumberDAO numberDAO;

    @Override
    public List<Number> getAll(){
        return numberDAO.findEntities();
    }
    @Override
    public void save(Number number) {
        numberDAO.insertEntity(number);
    }

    @Override
    public Number getById(int id) {
        return numberDAO.findEntityByID(id);
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);
    }
    @Override
    public void delete(int id){
        numberDAO.removeEntityByID(id);
    }
}
