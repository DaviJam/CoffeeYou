package com.appiciel.youcoffee.repository;

import com.appiciel.youcoffee.domain.Grain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Grain repository.
 */
public interface GrainRepository extends JpaRepository<Grain, Long> {
    /**
     * Gets grain by name.
     *
     * @param name the name
     * @return the grain by name
     */
    Grain getGrainByName(String name);

    /**
     * Delete grain by name.
     *
     * @param name the name
     */
    void deleteGrainByName(String name);
}
