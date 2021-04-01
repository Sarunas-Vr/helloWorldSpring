package com.helloworld.demo.Controller;

import com.helloworld.demo.Controller.model.NumberDAO;
import com.helloworld.demo.Controller.model.NumberDAOImpl;
import com.helloworld.demo.Controller.service.NumberService;
import com.helloworld.demo.Controller.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration = zymi konfiguracijos komponenta
// viduje leidzia kurti bean per metodus su @Bean
@Configuration
public class SpringConfig {

    // Bean - tai objektai, kurie sudaro Spring aplikacijos pagrinda.
    // Paprastai tai Java klase, realizuojanti tam tikra interfeisa ir JavaBean specifikacija.
    // Bean atitinka Singleton sablona - programines irangos projektavimo schema,
    // kuri riboja klases ivykdyma vienu "vieninteliu" egzemplioriu.
    // Tai naudinga, kai reikia tiksliai vieno objekto, norint koordinuoti veiksmus visoje sistemoje.
    @Bean
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai bean susieti priklausomybe.
    // Jeigu @Configuration klaseje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the bean as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    public NumberDAO getNumberDAO() {
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return (NumberService) new NumberServiceImpl();
    }
}
