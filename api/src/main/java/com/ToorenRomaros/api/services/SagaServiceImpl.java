package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.SagaDto;
import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.SagaRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class SagaServiceImpl implements SagaService{
    private final SagaRepository sagaRepository;
    private final ModelMapper modelMapper;

    public SagaServiceImpl(SagaRepository sagaRepository, ModelMapper modelMapper) {
        this.sagaRepository = sagaRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SagaDto createSaga(SagaDto sagaDto) {
        SagaEntity sagaEntity = modelMapper.map(sagaDto, SagaEntity.class);
        SagaEntity savedSaga = sagaRepository.save(sagaEntity);
        return modelMapper.map(savedSaga, SagaDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SagaDto updateSaga(UUID id, SagaDto sagaDto) {
        SagaEntity sagaEntity = modelMapper.map(sagaDto, SagaEntity.class);
        SagaEntity newSagaEntity = sagaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        BeanUtils.copyProperties(sagaEntity, newSagaEntity, Utils.getNullPropertyNames(sagaEntity));
        SagaEntity savedSaga = sagaRepository.save(newSagaEntity);
        return modelMapper.map(savedSaga, SagaDto.class);
    }

    @Override
    public SagaDto getSagaById(UUID id) {
        SagaEntity sagaEntity = sagaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        return modelMapper.map(sagaEntity, SagaDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteSaga(UUID id) {
        sagaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        sagaRepository.deleteById(id);
    }
}
