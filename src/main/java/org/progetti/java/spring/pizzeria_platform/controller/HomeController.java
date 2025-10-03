package org.progetti.java.spring.pizzeria_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {

        return "index";
    }
    

}
