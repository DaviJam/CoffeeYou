package com.appiciel.youcoffee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * The type User.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Username.
     */
    private String username;
    /**
     * The Email.
     */
    @Column(nullable = false,unique = true)
    private String email;
    /**
     * The Password.
     */
    private String password;

}
