package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.config.AppConfig;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.RestApiErrorHandler;
import com.ToorenRomaros.api.repositories.user.UserFollowerRepository;
import com.ToorenRomaros.api.services.UserFollowerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class UserFollowerControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UserFollowerService userFollowerService;
    @Mock
    private MessageSource messageSource;
    @InjectMocks
    private UserFollowerController userFollowerController;
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(UserFollowerControllerTest.class);
    private static final String id = "a1b9b31d-e73c-4112-af7c-b68530f38222";
    private UserEntity follower1;
    private UserEntity userEntity;
    private Pageable pageable;

    @BeforeEach
    public void setup() {
        ObjectMapper mapper = new AppConfig().objectMapper();
        this.modelMapper = new AppConfig().modelMapper();
        JacksonTester.initFields(this, mapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(mapper);

        mockMvc = MockMvcBuilders.standaloneSetup(userFollowerController)
                .setControllerAdvice(new RestApiErrorHandler(messageSource))
                .setMessageConverters(mappingJackson2HttpMessageConverter)
                .build();
        follower1 = new UserEntity();
        follower1.setId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad656"));
        follower1.setUsername("David");
        userEntity = new UserEntity();
        userEntity.setId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"));
        userEntity.setUsername("alice");
        pageable = PageRequest.of(0, 2);
    }

    @Test
    @DisplayName("returns followers by given user ID")
    void getAllUserFollowersByUserShouldWork() throws Exception {
        //given
        String type = "follower";
        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(
                LocalDate.now(), userEntity, follower1
        );
        Page<UserFollowerDto> page = new PageImpl<>(List.of(modelMapper.map(userFollowerEntity, UserFollowerDto.class)), pageable, 1);

        given(userFollowerService.getAllFollowsByUserIds(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), pageable, type)).willReturn(page);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640/follows")
                                .param("type", type)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(jsonObject.get(type)).isNotNull();
        assertThat(jsonObject.getJSONArray(type).getJSONObject(0).get("user")).isEqualTo(userEntity.getUsername());
        assertThat(jsonObject.getJSONArray(type).getJSONObject(0).get("follower")).isEqualTo(follower1.getUsername());
        verify(userFollowerService, times(1)).getAllFollowsByUserIds(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), pageable, type);
    }
    @Test
    @DisplayName("create and add follower to user")
    void createFollowerShouldWork() throws Exception {

        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(
                LocalDate.now(), userEntity, follower1
        );
        given(userFollowerService.addFollow(any(UUID.class),any(UUID.class),any(String.class))).willReturn(modelMapper.map(userFollowerEntity, UserFollowerDto.class));

        MockHttpServletResponse response = mockMvc.perform(
                        post("/api/v1/users/David/follows")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"userId\": \"b7a61937-6f59-4bbb-80a7-08d65d1ad640\",\n" +
                                        "    \"toFollowId\": \"b7a61937-6f59-4bbb-80a7-08d65d1ad656\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(jsonObject.get("created")).isNotNull();
        assertThat(jsonObject.getJSONObject("created").get("user")).isEqualTo(userEntity.getUsername());
        assertThat(jsonObject.getJSONObject("created").get("follower")).isEqualTo(follower1.getUsername());
        verify(userFollowerService, times(1)).addFollow(any(UUID.class),any(UUID.class),any(String.class));
    }
    @Test
    @DisplayName("delete a follow from user")
    void deleteFollowShouldWork() throws Exception {
        //given
        willDoNothing().given(userFollowerService).deleteFollowByIds(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad656"), UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), "David");

        //when
        MockHttpServletResponse result = mockMvc.perform(
                        delete("/api/v1/users/David/follows")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"toFollowId\": \"b7a61937-6f59-4bbb-80a7-08d65d1ad656\",\n" +
                                        "    \"userId\": \"b7a61937-6f59-4bbb-80a7-08d65d1ad640\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        verify(userFollowerService, times(1)).deleteFollowByIds(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad656"), UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), "David");
        assertThat(result.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
    }
}