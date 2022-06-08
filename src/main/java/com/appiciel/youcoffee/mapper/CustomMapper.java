package com.appiciel.youcoffee.mapper;

import com.appiciel.youcoffee.domain.Coffee;
import com.appiciel.youcoffee.domain.Grain;
import com.appiciel.youcoffee.dto.CoffeeDTO;
import com.appiciel.youcoffee.dto.GrainDTO;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;


public class CustomMapper {

    static public Coffee coffeeDTOToCoffee(CoffeeDTO coffeeDTO) {
        Coffee coffee = new Coffee(
                null,
               coffeeDTO.getGrains().stream().map(grainDTO -> CustomMapper.grainDTOToGrain(grainDTO))
                       .collect(Collectors.toList()),
               coffeeDTO.getName(),
               coffeeDTO.getPrice(),
               coffeeDTO.getQuantity());
    return coffee;
    };

    static public CoffeeDTO coffeeToCoffeeDTO(Coffee coffee) {
        CoffeeDTO coffeeDTO = new CoffeeDTO(
                coffee.getName(),
                coffee.getPrice(),
                coffee.getQuantity(),
                coffee.getGrains().stream().map(grain -> CustomMapper.grainToGrainDTO(grain))
                        .collect(Collectors.toList()));
        return coffeeDTO;
    }

    static public Grain grainDTOToGrain(GrainDTO grainDTO){
        Grain grain = new Grain(
                null,
                grainDTO.getName(),
                grainDTO.getOrigin(),
                grainDTO.getPrice(),
                grainDTO.getQuantity_g()
        );
        return grain;
    }

    static public GrainDTO grainToGrainDTO(Grain grain){
        GrainDTO grainDTO = new GrainDTO(
                grain.getName(),
                grain.getOrigin(),
                grain.getPrice(),
                grain.getQuantity_g()
        );
        return grainDTO;
    }

    static public Grain updatedGrainDTOToGrain(GrainDTO grainDTO, Grain grain){
        grain.setOrigin(grainDTO.getOrigin());
        grain.setPrice(grainDTO.getPrice());
        grain.setQuantity_g(grainDTO.getQuantity_g());
        return grain;
    }

    static public Coffee updatedCoffeeDTOToCoffee(CoffeeDTO entity, Coffee coffee) {
        coffee.setPrice(entity.getPrice());
        coffee.setGrains(entity.getGrains().stream().map(grainDTO -> CustomMapper.grainDTOToGrain(grainDTO)).collect(Collectors.toList()));
        coffee.setQuantity(entity.getQuantity());
    return coffee;
    }
}
