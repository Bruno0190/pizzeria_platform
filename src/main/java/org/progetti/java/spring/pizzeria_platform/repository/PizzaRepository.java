package org.progetti.java.spring.pizzeria_platform.repository;

import org.progetti.java.spring.pizzeria_platform.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
