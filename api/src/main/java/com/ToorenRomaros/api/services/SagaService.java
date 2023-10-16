package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.SagaDto;

import java.util.UUID;

public interface SagaService {
    SagaDto createSaga(SagaDto sagaDto);
    SagaDto updateSaga(UUID id, SagaDto sagaDto);
    SagaDto getSagaById(UUID id);
    void deleteSaga(UUID id);
}
