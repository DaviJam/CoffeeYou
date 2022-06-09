package com.appiciel.youcoffee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * The type Coffee.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coffee {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Grains.
     */
    @OneToMany(mappedBy = "id")
    private Collection<Grain> grains;
    /**
     * The Name.
     */
    @Column(unique = true)
    private String name;
    /**
     * The Price.
     */
    private Float price;
    /**
     * The Quantity.
     */
    private Long quantity;
}
