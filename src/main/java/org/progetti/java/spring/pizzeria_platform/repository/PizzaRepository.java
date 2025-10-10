package org.progetti.java.spring.pizzeria_platform.repository;

import org.progetti.java.spring.pizzeria_platform.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findByNameContainingIgnoreCase(String name);

}
