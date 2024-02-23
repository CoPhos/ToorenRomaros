package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.streamSite.CreateStreamSiteFilmDto;
import com.ToorenRomaros.api.dto.streamSite.GetStreamSiteFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteFilmRepository;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StreamSiteFilmServiceImpl implements StreamSiteFilmService{

    private final StreamSiteFilmRepository streamSiteFilmRepository;
    private final StreamSiteRepository streamSiteRepository;
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;

    public StreamSiteFilmServiceImpl(StreamSiteFilmRepository streamSiteFilmRepository, StreamSiteRepository streamSiteRepository, FilmRepository filmRepository, ModelMapper modelMapper) {
        this.streamSiteFilmRepository = streamSiteFilmRepository;
        this.streamSiteRepository = streamSiteRepository;
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public GetStreamSiteFilmDto createStreamSiteFilm(CreateStreamSiteFilmDto createStreamSiteFilmDto) {
        StreamSiteFilmEntity streamSiteFilmEntity = modelMapper.map(createStreamSiteFilmDto, StreamSiteFilmEntity.class);

        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createStreamSiteFilmDto.getFilmId())).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(UUID.fromString(createStreamSiteFilmDto.getStreamsiteId())).orElseThrow(() -> new ResourceNotFoundException("Stream site not found."));

        streamSiteFilmEntity.setFilm(filmEntity);
        streamSiteFilmEntity.setStreamSite(streamSiteEntity);

        StreamSiteFilmEntity savedStreamSiteFilmEntity = streamSiteFilmRepository.save(streamSiteFilmEntity);
        return modelMapper.map(savedStreamSiteFilmEntity, GetStreamSiteFilmDto.class);
    }
    @Override
    public List<GetStreamSiteFilmDto> getStreamSitesByFilmId(UUID id) {
        List<StreamSiteFilmEntity> streamSiteFilmEntities = streamSiteFilmRepository.findAllStreamSitesByFilmId(id.toString());
        return streamSiteFilmEntities.stream().map(streamSiteFilmEntity -> {
            return modelMapper.map(streamSiteFilmEntity, GetStreamSiteFilmDto.class);
        }).collect(Collectors.toList());
    }
    @Override
    public void deleteStreamSiteFilm(UUID id) {
        streamSiteFilmRepository.findById(id)
                .ifPresentOrElse(streamSiteFilmRepository::delete, () -> {
                    throw new ResourceNotFoundException("Relationship not found.");
                });
    }
}