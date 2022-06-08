package com.appiciel.youcoffee.service;

import com.appiciel.youcoffee.dto.GrainDTO;
import com.appiciel.youcoffee.mapper.CustomMapper;
import com.appiciel.youcoffee.repository.GrainRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GrainServiceTest {

    @InjectMocks
    private GrainService grainService;

    private GrainDTO grainDTO;

    @Mock
    private GrainRepository grainRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Creation of a grain")
    void create() {
        grainDTO = new GrainDTO("brasilo", "Brasil", 1.5f, 10L);
        GrainDTO grainDTOLocal = new GrainDTO("localGrain", "Brasil", 1.5f, 10L);

        Mockito.when(grainRepository.save(CustomMapper.grainDTOToGrain(grainDTOLocal))).thenReturn(CustomMapper.grainDTOToGrain(this.grainDTO));
        GrainDTO grainDTO1 = this.grainService.create(grainDTOLocal);
        Mockito.verify(grainRepository).save(CustomMapper.grainDTOToGrain(grainDTOLocal));

        Assertions.assertEquals(grainDTO1.getName(), grainDTO.getName());
        Assertions.assertEquals(grainDTO1.getPrice(), grainDTO.getPrice());
        Assertions.assertEquals(grainDTO1.getQuantity_g(), grainDTO.getQuantity_g());
        Assertions.assertEquals(grainDTO1.getOrigin(), grainDTO.getOrigin());
    }

    @Test
    @DisplayName("Updating of a grain")
    void update() {
        grainDTO = new GrainDTO("brasilo", "Brasil", 1.5f, 10L);
        GrainDTO grainDTOLocal = new GrainDTO("localGrain", "Brasil", 1.5f, 10L);

        Mockito.when(grainRepository.getGrainByName(grainDTO.getName())).thenReturn(CustomMapper.grainDTOToGrain(grainDTOLocal));
        GrainDTO grainDTO1 = this.grainService.update(grainDTOLocal, grainDTO.getName());
        Mockito.verify(grainRepository).getGrainByName(grainDTO.getName());

        Assertions.assertEquals(grainDTO1.getName(), grainDTOLocal.getName());
        Assertions.assertEquals(grainDTO1.getPrice(), grainDTOLocal.getPrice());
        Assertions.assertEquals(grainDTO1.getQuantity_g(), grainDTOLocal.getQuantity_g());
        Assertions.assertEquals(grainDTO1.getOrigin(), grainDTOLocal.getOrigin());
    }

    @Test
    @DisplayName("Getting of a grain")
    void get() {
        grainDTO = new GrainDTO("brasilo", "Brasil", 1.5f, 10L);
        Mockito.when(grainRepository.getGrainByName(grainDTO.getName())).thenReturn(CustomMapper.grainDTOToGrain(grainDTO));
        GrainDTO grainDTO1 = this.grainService.get(grainDTO.getName());
        Mockito.verify(grainRepository).getGrainByName(grainDTO.getName());

        Assertions.assertEquals(grainDTO1.getName(), grainDTO.getName());
        Assertions.assertEquals(grainDTO1.getPrice(), grainDTO.getPrice());
        Assertions.assertEquals(grainDTO1.getQuantity_g(), grainDTO.getQuantity_g());
        Assertions.assertEquals(grainDTO1.getOrigin(), grainDTO.getOrigin());
    }

    @Test
    @DisplayName("deleting of a grain")
    void delete() {
        grainDTO = new GrainDTO("brasilo", "Brasil", 1.5f, 10L);
        Mockito.doNothing().when(grainRepository).deleteGrainByName(grainDTO.getName());
        this.grainService.delete(grainDTO.getName());
        Mockito.verify(grainRepository).deleteGrainByName(grainDTO.getName());
    }
}