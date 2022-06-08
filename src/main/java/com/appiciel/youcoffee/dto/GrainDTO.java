package com.appiciel.youcoffee.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GrainDTO {
    private String name;
    private String origin;
    private Float price;
    private Long quantity_g;
}
