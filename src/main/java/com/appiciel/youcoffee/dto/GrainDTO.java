package com.appiciel.youcoffee.dto;

import lombok.*;

/**
 * The type Grain dto.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GrainDTO {
    /**
     * The Name.
     */
    private String name;
    /**
     * The Origin.
     */
    private String origin;
    /**
     * The Price.
     */
    private Float price;
    /**
     * The Quantity g.
     */
    private Long quantity_g;
}
