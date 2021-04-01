//package com.helloworld.demo.Controller;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//
//@Controller
//@EnableAutoConfiguration
//public class SkaiciuotuvoController {
//    String home(Model model) {
//        // Jeigu Model 'number' nepraeina validacijos - per ji grazinamos validacijos klaidos i View
//        model.addAttribute("number", new Number());
//        // graziname JSP faila, turi buti talpinami 'webapp -> WEB-INF -> jsp' aplanke
//        return "skaiciuotuvas";
//    }
//
//    // Kadangi skaiciuotuvo forma naudoja POST metoda, cia irgi nurodome POST
//    // SVARBU: parametras BindingResult turi eiti iskarto po anotacijos @Valid
//    // kitu atveju bus 'Validation failed for object'
//
//    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
//    String skaiciai(@Valid @ModelAttribute("number") Number e, BindingResult br,
//                    @RequestParam HashMap<String, String> skaiciai, ModelMap modelMap) {
//        if(br.hasErrors()) { // jeigu validacijos klaidos (zr. Number klaseje aprasyta validacija prie kiekvieno skaiciaus)
//            return "skaiciuotuvas"; // vartotojas lieka skaiciuotuvo lange tol, lkol neistaiso validacijos klaidu
//        } else { // praejo validacija - skaiciuojamas rezultatas
//            int sk1 = Integer.parseInt(skaiciai.get("sk1"));
//            int sk2 = Integer.parseInt(skaiciai.get("sk2"));
//            String zenklas = skaiciai.get("zenklas");
//            int rezultatas = 0;
//            if (zenklas.equals("+")) {
//                rezultatas = sk1 + sk2;
//            } else if (zenklas.equals("-")) {
//                rezultatas = sk1 - sk2;
//            } else if (zenklas.equals("*")) {
//                rezultatas = sk1 * sk2;
//            } else if (zenklas.equals("/")) {
//                rezultatas = sk1 / sk2;
//            }
//
//            // ModelMap objektas naudojamas siusti reikmes is Spring MVC controller i JSP
//            modelMap.put("sk1", sk1);
//            modelMap.put("sk2", sk2);
//            modelMap.put("zenklas", zenklas);
//            modelMap.put("rezultatas", rezultatas);
//
//            return "skaiciuoti";
//        }
//    }
//}
