package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.Saga;
import com.ToorenRomaros.api.repositories.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SagaService {

    @Autowired
    private SagaRepository sagaRepository;

    public void saveSaga(Saga saga){
        sagaRepository.save(saga);
    }

    public void deleteSaga(UUID id){
        sagaRepository.deleteById(id);
    }
}
