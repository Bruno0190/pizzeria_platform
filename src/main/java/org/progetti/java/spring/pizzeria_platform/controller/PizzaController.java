package org.progetti.java.spring.pizzeria_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import org.progetti.java.spring.pizzeria_platform.model.Pizza;
import org.progetti.java.spring.pizzeria_platform.repository.PizzaRepository;
import jakarta.validation.*;
import org.springframework.validation.*;



@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired PizzaRepository pizzaRepository;

    @GetMapping("/")
    public String indexPizza(@RequestParam(required = false) String name, Model model) {
        Boolean noResults = false;
        List<Pizza> listaPizza = pizzaRepository.findAll();
        List<String> listaPizzaNames = listaPizza.stream()
                                        .map(pizza -> pizza.getName())
                                        .toList();
        //Se il nome è presente nella lista dei nomi delle pizze, mostra i risultati filtrati
        if(name != null && !name.trim().isEmpty() && listaPizzaNames.contains(name)){
            List<Pizza> pizzas = pizzaRepository.findByNameContainingIgnoreCase(name);
            model.addAttribute("pizzas", pizzas);
        // Altrimenti, se il nome non è vuoto ma non è presente nella lista, mostra il messaggio di nessun risultato
        } else if(name!= null && !name.trim().isEmpty() && !listaPizzaNames.contains(name)){
            noResults = true;
            model.addAttribute("noResults", noResults);
            model.addAttribute("message", "Nessuna pizza corrispondente questo nome");
        // Altrimenti mostra tutte le pizze di default
        } else {
            List<Pizza> pizzas = pizzaRepository.findAll();
            // Ogni Pizza nella lista è stata creata usando i setter
            model.addAttribute("pizzas", pizzas);    
        }
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String showPizza(@PathVariable Long id, Model model) {
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        // Hibernate ha usato i setter per creare questo oggetto dal DB
        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }

    @GetMapping("/create")
    public String getCreatePizza(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizzas/create";
    }

    @PostMapping("/create")
    public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pizza", pizza);
            return "pizzas/create";
        }

        pizzaRepository.save(pizza);
        return "redirect:/pizzas/";
    }

    @GetMapping("/edit/{id}")
    public String editPizza(@PathVariable Long id, Model model) {
        model.addAttribute("pizza", pizzaRepository.findById(id).orElse(null));
        return "pizzas/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("pizza", pizza);
            return "pizzas/edit";
        }
        pizzaRepository.save(pizza);
        return "redirect:/pizzas/";
    }

    @PostMapping("/delete/{id}")
    public String deletePizza(@PathVariable("id") Long id) {
        pizzaRepository.deleteById(id);
        return "redirect:/pizzas/";
    }
    
        
}
