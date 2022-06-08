package com.appiciel.youcoffee.repository;

import com.appiciel.youcoffee.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee getCoffeeByName(String name);
    void deleteCoffeeByName(String name);
}
