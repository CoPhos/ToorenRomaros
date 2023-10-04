package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.dto.user.UserFollowingDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserFollowerServiceImpl implements UserFollowerService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserFollowerRepository userFollowerRepository;

    public UserFollowerServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserFollowerRepository userFollowerRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userFollowerRepository = userFollowerRepository;
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public UserFollowerDto addFollow(UUID idUser, UUID toFollow, String type, String username) {
        UserFollowerEntity newFollow = newFollow(idUser, toFollow, type);
        assert newFollow != null;
        return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public void deleteFollowByIds(UUID idUser, UUID toFollow, String type, String username) {
        UserFollowerEntity entity = deleteFollow(idUser, toFollow, type);
        assert entity != null;
        userFollowerRepository.deleteById(entity.getId());
    }
    @Override
    public Page<?> getAllFollowsByUserIds(UUID id, Pageable pageRequest, String type) {
        List<?> allFollow = getAllFollows(id, pageRequest, type);
        int start = (int) pageRequest.getOffset();
        assert allFollow != null;
        int end = Math.min((start + pageRequest.getPageSize()), allFollow.size());
        List<?> pageContent = allFollow.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollow.size());
    }
    private UserFollowerEntity newFollow(UUID idUser, UUID toFollow, String type){
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));

        if(Objects.equals(type, "follower")){
            return new UserFollowerEntity(LocalDate.now(), follower, user);
        }else if(Objects.equals(type, "following")){
            return new UserFollowerEntity(LocalDate.now(), user, follower);

        }
        return null;
    }
    private List<?> getAllFollows(UUID id, Pageable pageRequest, String type){
        if(Objects.equals(type, "follower")){
            userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

            List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(id.toString(), pageRequest);
            if (entities == null) {
                throw new ResourceNotFoundException("");
            }
            return entities.stream().map(value -> modelMapper.map(value, UserFollowerDto.class)).collect(Collectors.toList());

        }else if(Objects.equals(type, "following")){
            userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));

            List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowingsByUser(id.toString(), pageRequest);
            if (entities == null) {
                throw new ResourceNotFoundException("");
            }
            return entities.stream().map(value -> modelMapper.map(value, UserFollowingDto.class)).collect(Collectors.toList());
        }
        return null;
    }
    private UserFollowerEntity deleteFollow(UUID idUser, UUID toFollow, String type){
        if(Objects.equals(type, "follower")){
            return userFollowerRepository.findByFollowerIdAndUserId(toFollow.toString(), idUser.toString()).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        }else if(Objects.equals(type, "following")){
            return userFollowerRepository.findByFollowerIdAndUserId(idUser.toString(), toFollow.toString()).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        }
        return null;
    }
}
