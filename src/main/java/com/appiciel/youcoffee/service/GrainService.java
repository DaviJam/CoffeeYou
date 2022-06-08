package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.domain.Grain;
import com.appiciel.youcoffee.dto.GrainDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.GrainRepository;
import org.springframework.stereotype.Service;

@Service
public class GrainService implements com.appiciel.youcoffee.service.Service<GrainDTO> {

    private GrainRepository grainRepository;

    public GrainService(GrainRepository grainRepository) {
        this.grainRepository = grainRepository;
    }

    @Override
    public GrainDTO create(GrainDTO entity) {
        return CustomMapper.grainToGrainDTO(this.grainRepository.save(CustomMapper.grainDTOToGrain(entity)));
    }

    @Override
    public GrainDTO update(GrainDTO entity, String name) {
        Grain grain = this.grainRepository.getGrainByName(name);
        grain = CustomMapper.updatedGrainDTOToGrain(entity,grain);
        return CustomMapper.grainToGrainDTO(grain);
    }

    @Override
    public GrainDTO get(String name) {
        return CustomMapper.grainToGrainDTO(this.grainRepository.getGrainByName(name));
    }

    @Override
    public void delete(String name) {
        this.grainRepository.deleteGrainByName(name);
    }
}
