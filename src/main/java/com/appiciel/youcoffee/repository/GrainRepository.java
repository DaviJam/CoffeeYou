package com.appiciel.youcoffee.repository;

import com.appiciel.youcoffee.domain.Grain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrainRepository extends JpaRepository<Grain, Long> {
    Grain getGrainByName(String name);
    void deleteGrainByName(String name);
}
