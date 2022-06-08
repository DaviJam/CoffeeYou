package com.appiciel.youcoffee.dto;

import lombok.*;

import java.util.Collection;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeDTO {
    private String name;
    private Float price;
    private Long quantity;
    private Collection<GrainDTO> grains;
}
