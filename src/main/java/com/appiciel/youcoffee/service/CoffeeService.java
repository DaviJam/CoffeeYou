package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.domain.Coffee;
import com.appiciel.youcoffee.dto.CoffeeDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CoffeeService implements com.appiciel.youcoffee.service.Service<CoffeeDTO> {

    private CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public CoffeeDTO create(CoffeeDTO entity) {
        return CustomMapper.coffeeToCoffeeDTO(this.coffeeRepository.save(CustomMapper.coffeeDTOToCoffee(entity)));
    }

    @Override
    public CoffeeDTO update(CoffeeDTO entity, String name) {
        Coffee coffee = this.coffeeRepository.getCoffeeByName(name);
        coffee = CustomMapper.updatedCoffeeDTOToCoffee(entity, coffee);
        return CustomMapper.coffeeToCoffeeDTO(coffee);
    }

    @Override
    public CoffeeDTO get(String name) {
        return CustomMapper.coffeeToCoffeeDTO(this.coffeeRepository.getCoffeeByName(name));
    }

    @Override
    public void delete(String name) {
        this.coffeeRepository.deleteCoffeeByName(name);
    }
}
