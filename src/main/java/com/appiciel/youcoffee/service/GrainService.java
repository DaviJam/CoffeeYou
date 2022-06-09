package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.domain.Grain;
import com.appiciel.youcoffee.dto.GrainDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.GrainRepository;
import org.springframework.stereotype.Service;

/**
 * The type Grain service.
 */
@Service
public class GrainService implements com.appiciel.youcoffee.service.Service<GrainDTO> {

    /**
     * The Grain repository.
     */
    private GrainRepository grainRepository;

    /**
     * Instantiates a new Grain service.
     *
     * @param grainRepository the grain repository
     */
    public GrainService(GrainRepository grainRepository) {
        this.grainRepository = grainRepository;
    }

    /**
     * Create grain dto.
     *
     * @param entity the entity
     * @return the grain dto
     */
    @Override
    public GrainDTO create(GrainDTO entity) {
        return CustomMapper.grainToGrainDTO(this.grainRepository.save(CustomMapper.grainDTOToGrain(entity)));
    }

    /**
     * Update grain dto.
     *
     * @param entity the entity
     * @param name   the name
     * @return the grain dto
     */
    @Override
    public GrainDTO update(GrainDTO entity, String name) {
        Grain grain = this.grainRepository.getGrainByName(name);
        grain = CustomMapper.updatedGrainDTOToGrain(entity,grain);
        return CustomMapper.grainToGrainDTO(grain);
    }

    /**
     * Get grain dto.
     *
     * @param name the name
     * @return the grain dto
     */
    @Override
    public GrainDTO get(String name) {
        return CustomMapper.grainToGrainDTO(this.grainRepository.getGrainByName(name));
    }

    /**
     * Delete.
     *
     * @param name the name
     */
    @Override
    public void delete(String name) {
        this.grainRepository.deleteGrainByName(name);
    }
}
