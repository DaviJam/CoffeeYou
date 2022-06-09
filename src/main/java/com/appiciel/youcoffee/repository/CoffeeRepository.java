package com.appiciel.youcoffee.repository;

import com.appiciel.youcoffee.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Coffee repository.
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    /**
     * Gets coffee by name.
     *
     * @param name the name
     * @return the coffee by name
     */
    Coffee getCoffeeByName(String name);

    /**
     * Delete coffee by name.
     *
     * @param name the name
     */
    void deleteCoffeeByName(String name);
}
