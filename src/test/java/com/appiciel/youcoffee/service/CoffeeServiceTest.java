package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.dto.CoffeeDTO;
import com.appiciel.youcoffee.dto.GrainDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.CoffeeRepository;
import com.appiciel.youcoffee.repository.GrainRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.Matchers.any;

@ExtendWith(MockitoExtension.class)
public class CoffeeServiceTest {

    @InjectMocks
    private CoffeeService coffeeService;

    @Mock
    private CoffeeRepository coffeeRepository;

    private CoffeeDTO coffeeDTO;

    @Test
    @DisplayName("Creation of a coffee")
    void create() {
        coffeeDTO = new CoffeeDTO("brasil", 1.5f, 2L, List.of(new GrainDTO("brasilo", "Brasil", 1.5f, 10L)));
        CoffeeDTO coffeeDTOLocal = new CoffeeDTO("local", 1.5f, 2L, List.of(new GrainDTO("localGrain", "Brasil", 1.5f, 10L)));

        Mockito.when(coffeeRepository.save(CustomMapper.coffeeDTOToCoffee(coffeeDTOLocal))).thenReturn(CustomMapper.coffeeDTOToCoffee(this.coffeeDTO));
        CoffeeDTO coffeeDTO1 = this.coffeeService.create(coffeeDTOLocal);
        Mockito.verify(coffeeRepository).save(CustomMapper.coffeeDTOToCoffee(coffeeDTOLocal));

        Assertions.assertEquals(coffeeDTO1.getName(), coffeeDTO.getName());
        Assertions.assertEquals(coffeeDTO1.getPrice(), coffeeDTO.getPrice());
        Assertions.assertEquals(coffeeDTO1.getQuantity(), coffeeDTO.getQuantity());
        coffeeDTO1.getGrains().stream().forEach(
                grainDTO -> Assertions.assertNotNull(coffeeDTO.getGrains().stream().filter(
                        grainDTO1 -> grainDTO.getName().matches(grainDTO1.getName()))));
    }

    @Test
    @DisplayName("Updating of a coffee")
    void update() {
        coffeeDTO = new CoffeeDTO("brasil", 1.5f, 2L, List.of(new GrainDTO("brasilo", "Brasil", 1.5f, 10L)));
        CoffeeDTO coffeeDTOLocal = new CoffeeDTO("brasil", 2.5f, 5L, List.of(new GrainDTO("localGrain", "Brasil", 1.5f, 10L)));

        Mockito.when(coffeeRepository.getCoffeeByName(coffeeDTO.getName())).thenReturn(CustomMapper.coffeeDTOToCoffee(coffeeDTOLocal));
        CoffeeDTO coffeeDTO1 = this.coffeeService.update(coffeeDTOLocal, coffeeDTO.getName());
        Mockito.verify(coffeeRepository).getCoffeeByName(coffeeDTO.getName());

        Assertions.assertEquals(coffeeDTO1.getName(), coffeeDTOLocal.getName());
        Assertions.assertEquals(coffeeDTO1.getPrice(), coffeeDTOLocal.getPrice());
        Assertions.assertEquals(coffeeDTO1.getQuantity(), coffeeDTOLocal.getQuantity());
        coffeeDTO1.getGrains().stream().forEach(
                grainDTO -> Assertions.assertNotNull(coffeeDTOLocal.getGrains().stream().filter(
                        grainDTO1 -> grainDTO.getName().matches(grainDTO1.getName()))));
    }

    @Test
    @DisplayName("Getting of a coffee")
    void get() {
        coffeeDTO = new CoffeeDTO("brasil", 1.5f, 2L, List.of(new GrainDTO("brasilo", "Brasil", 1.5f, 10L)));
        Mockito.when(coffeeRepository.getCoffeeByName(coffeeDTO.getName())).thenReturn(CustomMapper.coffeeDTOToCoffee(coffeeDTO));
        CoffeeDTO coffeeDTO1 = this.coffeeService.get(coffeeDTO.getName());
        Mockito.verify(coffeeRepository).getCoffeeByName(coffeeDTO.getName());

        Assertions.assertEquals(coffeeDTO1.getName(), coffeeDTO.getName());
        Assertions.assertEquals(coffeeDTO1.getPrice(), coffeeDTO.getPrice());
        Assertions.assertEquals(coffeeDTO1.getQuantity(), coffeeDTO.getQuantity());
        coffeeDTO1.getGrains().stream().forEach(
                grainDTO -> Assertions.assertNotNull(coffeeDTO.getGrains().stream().filter(
                        grainDTO1 -> grainDTO.getName().matches(grainDTO1.getName()))));
    }

    @Test
    @DisplayName("deleting of a coffee")
    void delete() {
        coffeeDTO = new CoffeeDTO("brasil", 1.5f, 2L, List.of(new GrainDTO("brasilo", "Brasil", 1.5f, 10L)));
        Mockito.doNothing().when(coffeeRepository).deleteCoffeeByName(coffeeDTO.getName());
        this.coffeeService.delete(coffeeDTO.getName());
        Mockito.verify(coffeeRepository).deleteCoffeeByName(coffeeDTO.getName());
    }

}