package com.helloworld.demo.Controller;

import com.helloworld.demo.Controller.model.Number;
import com.helloworld.demo.Controller.model.User;
import com.helloworld.demo.Controller.service.NumberService;
import com.helloworld.demo.Controller.service.SecurityService;
import com.helloworld.demo.Controller.service.UserService;
import com.helloworld.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
// @EnableAutoConfiguration - zymi konfiguracijos komponenta. Viduje leidzia kurti bean metodus su @Bean
// Si klases lygio anotacija nurodo Spring karkasui "atspeti" konfiguracija,
// remiantis priklausomybemis (jar bibliotekos), kurias programuotojas itrauke i projekta.
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class CalculatorController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    // @Autowire - naudojamas automatinei priklausomybiu injekcijai
    // Kad panaudoti @Autowire anotacija, reikia pirmiausia tureti apsirasius @Bean @Configuration klaseje
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai bean susieti priklausomybe.
    // Jeigu @Configuration klaseje yra daugiau neigu vienas bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the bean as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberService")
    public NumberService numberService;

//    @RequestMapping(method = RequestMethod.GET, value = "/")
    @GetMapping({"/", "/skaiciuotuvas"})

    // Marsrutizavimo informacija. Siuo atveju, ji nurodo Spring karkasui,
    // jog visas HTTP uzklausas, kuriu kelias yra "/" apdoros metodas "namai".
    String home(Model model) {
        // Jeigu Model 'number' nepraeina validacijos - per ji grazinamos validacijos klaidos i View
        model.addAttribute("number", new Number());
        // graziname JSP faila, turi buti talpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "skaiciuotuvas";
    }

    // Kadangi skaiciuotuvo forma naudoja POST metoda, cia irgi nurodome POST
    // SVARBU: parametras BindingResult turi eiti iskarto po anotacijos @Valid
    // kitu atveju bus 'Validation failed for object'

    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciai(@Valid @ModelAttribute("number") Number e, BindingResult br,
                    @RequestParam HashMap<String, String> skaiciai, ModelMap modelMap) {
        if(br.hasErrors()) { // jeigu validacijos klaidos (zr. Number klaseje aprasyta validacija prie kiekvieno skaiciaus)
            return "skaiciuotuvas"; // vartotojas lieka skaiciuotuvo lange tol, lkol neistaiso validacijos klaidu
        } else { // praejo validacija - skaiciuojamas rezultatas
            int sk1 = Integer.parseInt(skaiciai.get("sk1"));
            int sk2 = Integer.parseInt(skaiciai.get("sk2"));
            String zenklas = skaiciai.get("zenklas");
            int rezultatas = 0;
            if (zenklas.equals("+")) {
                rezultatas = sk1 + sk2;
            } else if (zenklas.equals("-")) {
                rezultatas = sk1 - sk2;
            } else if (zenklas.equals("*")) {
                rezultatas = sk1 * sk2;
            } else if (zenklas.equals("/")) {
                rezultatas = sk1 / sk2;
            }

            // ModelMap objektas naudojamas siusti reikmes is Spring MVC controller i JSP
            modelMap.put("sk1", sk1);
            modelMap.put("sk2", sk2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", rezultatas);

            // Kreipiames i service, kuris savo ruoztu kreipiasi i DAO ir issaugo irasa i DB
            numberService.save(new Number(sk1, sk2, zenklas, rezultatas));
            return "skaiciuoti";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciai")
    public String getAllNumbers(Model model) {
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rodyti{id}")
    public String getById(@RequestParam("id") int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "skaicius";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trinti{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        numberService.delete(id);
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atnaujinti{id}")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "atnaujinti";
    }

    // Kadangi atnaujinti skaiciu forma naudoja POST metoda, cia irgi nurodome POST
    @RequestMapping(method = RequestMethod.POST, value = "/atnaujintiSkaiciu")
    public String updateNumber(@ModelAttribute("skaicius") Number number) {
        numberService.update(number);
        return "redirect:/rodyti?id=" + number.getId();
    }

    @GetMapping("/registruoti")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registruoti";
    }
    @PostMapping("/registruoti")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registruoti";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/skaiciuotuvas";
    }

    @GetMapping("/prisijungti")
    public String login(Model model, String error, String logout) {
        if(error != null)
            model.addAttribute("error", "Ivestas prisijungimo vardas ir/ arba slaptazodis yra neteisingi");

        if(logout != null)
            model.addAttribute("message", "Sekmingai atsijungete");
        return "prisijungti";
    }
}



