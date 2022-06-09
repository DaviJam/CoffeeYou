package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.domain.Coffee;
import com.appiciel.youcoffee.dto.CoffeeDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The type Coffee service.
 */
@Service
@Transactional
public class CoffeeService implements com.appiciel.youcoffee.service.Service<CoffeeDTO> {

    /**
     * The Coffee repository.
     */
    private CoffeeRepository coffeeRepository;

    /**
     * Instantiates a new Coffee service.
     *
     * @param coffeeRepository the coffee repository
     */
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    /**
     * Create coffee dto.
     *
     * @param entity the entity
     * @return the coffee dto
     */
    @Override
    public CoffeeDTO create(CoffeeDTO entity) {
        return CustomMapper.coffeeToCoffeeDTO(this.coffeeRepository.save(CustomMapper.coffeeDTOToCoffee(entity)));
    }

    /**
     * Update coffee dto.
     *
     * @param entity the entity
     * @param name   the name
     * @return the coffee dto
     */
    @Override
    public CoffeeDTO update(CoffeeDTO entity, String name) {
        Coffee coffee = this.coffeeRepository.getCoffeeByName(name);
        coffee = CustomMapper.updatedCoffeeDTOToCoffee(entity, coffee);
        return CustomMapper.coffeeToCoffeeDTO(coffee);
    }

    /**
     * Get coffee dto.
     *
     * @param name the name
     * @return the coffee dto
     */
    @Override
    public CoffeeDTO get(String name) {
        return CustomMapper.coffeeToCoffeeDTO(this.coffeeRepository.getCoffeeByName(name));
    }

    /**
     * Delete.
     *
     * @param name the name
     */
    @Override
    public void delete(String name) {
        this.coffeeRepository.deleteCoffeeByName(name);
    }
}
