package com.appiciel.youcoffee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Grain.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grain {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Name.
     */
    @Column(unique = true)
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
