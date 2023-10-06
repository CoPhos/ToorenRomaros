package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.user.UserFollowerDto;
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
    public UserFollowerDto addFollow(UUID idUser, UUID toFollow, String username) {
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        UserEntity follower = userRepository.findById(toFollow).orElseThrow(() -> new UserNotFoundException("'" + toFollow + "'"));
        UserFollowerEntity newFollow = new UserFollowerEntity(LocalDate.now(), user, follower);
        return modelMapper.map(userFollowerRepository.save(newFollow), UserFollowerDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public void deleteFollowByIds(UUID idUser, UUID follow, String username) {
        UserFollowerEntity entity = userFollowerRepository.findByUserIdAndFollowId(idUser.toString(), follow.toString()).orElseThrow(() -> new UserNotFoundException("'" + idUser + "'"));
        userFollowerRepository.deleteById(entity.getId());
    }
    @Override
    public Page<UserFollowerDto> getAllFollowsByUserIds(UUID id, Pageable pageRequest, String type) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("'" + id + "' does not exists"));
        List<UserFollowerDto> allFollow = getAllFollows(id, pageRequest, type);
        assert allFollow != null;
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), allFollow.size());
        List<UserFollowerDto> pageContent = allFollow.subList(start, end);

        return new PageImpl<>(pageContent, pageRequest, allFollow.size());
    }

    private List<UserFollowerDto> getAllFollows(UUID id, Pageable pageRequest, String type){
        if(Objects.equals(type, "follower")){
            List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowersByUser(id.toString(), pageRequest);
            if (entities == null) {
                throw new ResourceNotFoundException("");
            }
            return entities.stream().map(value -> modelMapper.map(value, UserFollowerDto.class)).collect(Collectors.toList());

        }else if(Objects.equals(type, "following")){
            List<UserFollowerEntity> entities = userFollowerRepository.findAllFollowingsByUser(id.toString(), pageRequest);
            if (entities == null) {
                throw new ResourceNotFoundException("");
            }

            return entities.stream().map(value -> modelMapper.map(value, UserFollowerDto.class)).collect(Collectors.toList());
        }
        return null;
    }
}
