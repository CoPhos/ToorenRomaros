package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.film.FilmDto;
import com.ToorenRomaros.api.dto.tag.TagDto;
import com.ToorenRomaros.api.dto.tag.TagPostDto;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.tag.TagEntity;
import com.ToorenRomaros.api.entities.tag.TagPostEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.tag.TagPostRepository;
import com.ToorenRomaros.api.repositories.tag.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TagPostServiceImpl implements  TagPostService{
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final TagPostRepository tagPostRepository;
    private final ModelMapper modelMapper;

    public TagPostServiceImpl(PostRepository postRepository, TagRepository tagRepository, TagPostRepository tagPostRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
        this.tagPostRepository = tagPostRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TagPostDto createTagPost(TagPostDto tagPostDto) {
        PostEntity postEntity = postRepository.findById(UUID.fromString(tagPostDto.getPost())).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        TagEntity tagEntity = tagRepository.findById(UUID.fromString(tagPostDto.getTag())).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        TagPostEntity tagPostEntity = new TagPostEntity(postEntity, tagEntity);
        return modelMapper.map(tagPostRepository.save(tagPostEntity), TagPostDto.class);
    }

    @Override
    public TagPostDto updateTagPost(UUID id, TagPostDto tagPostDto) {
        TagPostEntity existingTagPostEntity = tagPostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        setEntities(existingTagPostEntity, tagPostDto);
        return modelMapper.map(tagPostRepository.save(existingTagPostEntity), TagPostDto.class);
    }

    @Override
    public void deleteTagPost(UUID uuid) {
        tagPostRepository.findById(uuid)
                .ifPresentOrElse(tagPostRepository::delete, () -> {
                    throw new ResourceNotFoundException("'" + uuid + "'");
                });
    }

    private void setEntities(TagPostEntity tagPostEntity, TagPostDto tagPostDto){
        if(tagPostDto.getPost() != null){
            PostEntity postEntity = postRepository.findById(UUID.fromString(tagPostDto.getPost())).orElseThrow(() -> new ResourceNotFoundException("Post not found: " + tagPostDto.getPost()));
            tagPostEntity.setPost(postEntity);
        }
        if(tagPostDto.getTag() != null){
            TagEntity tagEntity = tagRepository.findById(UUID.fromString(tagPostDto.getPost())).orElseThrow(() -> new ResourceNotFoundException("Post not found: " + tagPostDto.getTag()));
            tagPostEntity.setTag(tagEntity);
        }
    }
}
