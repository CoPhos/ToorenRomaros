package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.SagaEntity;
import com.ToorenRomaros.api.repositories.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SagaService {

    @Autowired
    private SagaRepository sagaRepository;

    public void saveSaga(SagaEntity sagaEntity){
        sagaRepository.save(sagaEntity);
    }

    public void deleteSaga(UUID id){
        sagaRepository.deleteById(id);
    }
}
