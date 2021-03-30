package com.helloworld.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;

import java.util.HashMap;


@Controller
public class CalculatorController {

    // @RestController negrazina view.
    // Kadangi mums reikia grazinti view pagal Spring MVC, naudojame @Controller
    @RequestMapping(method = RequestMethod.GET, value = "/namai")
    String home(){
        // graziname JSP faila, turi buti tarpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "skaiciuotuvas";
    }
    // Kadangi skaiciuotuvo forma naudoja POST metoda, cia irgi nurodome POST
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai,ModelMap modelMap) {
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

        return "skaiciuoti";
    }
}
