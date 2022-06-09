package com.appiciel.youcoffee.dto;

import lombok.*;

import java.util.Collection;

/**
 * The type Coffee dto.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeDTO {
    /**
     * The Name.
     */
    private String name;
    /**
     * The Price.
     */
    private Float price;
    /**
     * The Quantity.
     */
    private Long quantity;
    /**
     * The Grains.
     */
    private Collection<GrainDTO> grains;
}
