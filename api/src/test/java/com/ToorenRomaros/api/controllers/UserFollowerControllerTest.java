package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.config.AppConfig;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.dto.user.UserFollowerDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.RestApiErrorHandler;
import com.ToorenRomaros.api.services.UserFollowerService;
import com.ToorenRomaros.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.json.JacksonTester;
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
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class UserFollowerControllerTest {
    private static final String id = "a1b9b31d-e73c-4112-af7c-b68530f38222";
    private MockMvc mockMvc;
    @Mock
    private UserFollowerService userFollowerService;
    @Mock
    private MessageSource messageSource;
    @Mock
    private Page<?> userFollower;
    @InjectMocks
    private UserFollowerController userFollowerController;
    private ModelMapper modelMapper;
    private Pageable pageRequest;
    private final UserFollowerDto model = new UserFollowerDto();
    private JacksonTester<UserFollowerDto> UserFollowerDtoTester;


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
    }

//    @Test
//    @DisplayName("returns followers by given user ID")
//    void getAllUserFollowersByUserShouldWork() throws Exception {
//        UserEntity follower1 = new UserEntity();
//        follower1.setId(UUID.randomUUID());
//        follower1.setUsername("David");
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUID.randomUUID());
//        userEntity.setUsername("alice");
//
//        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(
//                LocalDate.now(),
//                userEntity,
//                follower1
//        );
//
//        BeanUtils.copyProperties(userFollowerEntity, model);
//
//        pageRequest = PageRequest.of(0, 2);
//        userFollower = new PageImpl<>(List.of(model), pageRequest, List.of(model).size());
//        //given
//        given(userFollowerService.getAllFollowsByUserIds(any(UUID.class), any(PageRequest.class), "follower")).willReturn(userFollower);
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(
//                        get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640/followers")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        JSONObject jsonObject = new JSONObject(response.getContentAsString());
//        assertThat(jsonObject.get("totalPages")).isEqualTo(1);
//        assertThat(jsonObject.get("totalItems")).isEqualTo(1);
//        assertThat(jsonObject.get("currentPage")).isEqualTo(0);
//        assertThat(jsonObject.get("followers")).isNotNull();
//
//        String expected = jsonObject.get("followers").toString();
//        JSONArray jsonData = new JSONArray(UserTester.write(List.of(model)).getJson());
//        JSONAssert.assertEquals(expected, jsonData, false);
//    }
//
//    @Test
//    @DisplayName("returns followings by given user ID")
//    void getAllUserFollowingsByUserShouldWork() throws Exception {
//        UserEntity follower1 = new UserEntity();
//        follower1.setId(UUID.randomUUID());
//        follower1.setUsername("David");
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"));
//        userEntity.setUsername("alice");
//
//        UserFollowerEntity userFollowerEntity = new UserFollowerEntity();
//        userFollowerEntity.setId(UUID.randomUUID());
//        userFollowerEntity.setFollower(userEntity);
//        userFollowerEntity.setFollowDate(LocalDate.now());
//        userFollowerEntity.setUser(follower1);
//        BeanUtils.copyProperties(userFollowerEntity, model2);
////        model.setUsername(userFollowerEntity.getFollower().getUsername());
////        model.setFollowDate(userFollowerEntity.getFollowDate());
//
//        pageRequest = PageRequest.of(0, 2);
//        userFollowing = new PageImpl<>(List.of(model2), pageRequest, List.of(model2).size());
//        //given
//        given(userService.getAllFollowingsByUserId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), pageRequest)).willReturn(userFollowing);
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(
//                        get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640/followings")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        JSONObject jsonObject = new JSONObject(response.getContentAsString());
//        assertThat(jsonObject.get("totalPages")).isEqualTo(1);
//        assertThat(jsonObject.get("totalItems")).isEqualTo(1);
//        assertThat(jsonObject.get("currentPage")).isEqualTo(0);
//        assertThat(jsonObject.get("followings")).isNotNull();
//
//        String expected = jsonObject.get("followings").toString();
//        JSONArray jsonData = new JSONArray(UserTester2.write(List.of(model2)).getJson());
//        JSONAssert.assertEquals(expected, jsonData, false);
//    }
//
//    @Test
//    @DisplayName("create and add follower to user")
//    void createFollowerShouldWork() throws Exception {
//        //given
//        UserEntity follower1 = new UserEntity();
//        follower1.setId(UUID.fromString("a1b9b31d-e73c-4112-af7c-b68530f38222"));
//        follower1.setUsername("sara_wilson");
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUID.fromString("6f95b5af-4d6f-448c-8f3d-ca54521f4653"));
//        userEntity.setUsername("chris_martin");
//        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), userEntity, follower1);
//
//        given(userService.addFollowerByIds(UUID.fromString(id), UUID.fromString(id2), "sara_wilson")).willReturn(new UserFollowerDto("chris_martin", LocalDate.now()));
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(
//                        post("/api/v1/users/sara_wilson/followers")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content("{   \n" +
//                                        "    \"userId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\",\n" +
//                                        "    \"toFollowId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\"\n" +
//                                        "}")
//                                .characterEncoding("utf-8")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        JSONObject jsonObject = new JSONObject(response.getContentAsString());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//
//        String expected = jsonObject.get("created").toString();
//        JSONObject jsonData = new JSONObject(userFollowerDtoTester.write(modelMapper.map(userFollowerEntity, UserFollowerDto.class)).getJson());
//        JSONAssert.assertEquals(expected, jsonData, false);
//    }
//
//    @Test
//    @DisplayName("create and add following to user")
//    void createFollowingShouldWork() throws Exception {
//        //given
//        UserEntity follower1 = new UserEntity();
//        follower1.setId(UUID.fromString("a1b9b31d-e73c-4112-af7c-b68530f38222"));
//        follower1.setUsername("sara_wilson");
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(UUID.fromString("6f95b5af-4d6f-448c-8f3d-ca54521f4653"));
//        userEntity.setUsername("chris_martin");
//        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), follower1, userEntity);
//
//        given(userService.addFollowingsByIds(UUID.fromString(id), UUID.fromString(id2), "chris_martin")).willReturn(new UserFollowerDto("sara_wilson", LocalDate.now()));
//
//        //when
//        MockHttpServletResponse response = mockMvc.perform(
//                        post("/api/v1/users/chris_martin/followings")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content("{   \n" +
//                                        "    \"userId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\",\n" +
//                                        "    \"toFollowId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\"\n" +
//                                        "}")
//                                .characterEncoding("utf-8")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        JSONObject jsonObject = new JSONObject(response.getContentAsString());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//
//        String expected = jsonObject.get("created").toString();
//        JSONObject jsonData = new JSONObject(userFollowerDtoTester.write(modelMapper.map(userFollowerEntity, UserFollowerDto.class)).getJson());
//        JSONAssert.assertEquals(expected, jsonData, false);
//    }
//
//    @Test
//    @DisplayName("delete a follower from user")
//    void deleteFollowerShouldWork() throws Exception {
//        //given
//        willDoNothing().given(userService).deleteFollowerByids(UUID.fromString(id), UUID.fromString(id2), "sara_wilson");
//
//        //when
//        MockHttpServletResponse result = mockMvc.perform(
//                        delete("/api/v1/users/sara_wilson/followers")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content("{   \n" +
//                                        "    \"userId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\",\n" +
//                                        "    \"toFollowId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\"\n" +
//                                        "}")
//                                .characterEncoding("utf-8")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        verify(userService, times(1)).deleteFollowerByids(UUID.fromString(id), UUID.fromString(id2), "sara_wilson");
//        assertThat(result.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
//    }
//
//    @Test
//    @DisplayName("delete a following from user")
//    void deleteFollowingShouldWork() throws Exception {
//        //given
//        willDoNothing().given(userService).deleteFollowingsByids(UUID.fromString(id), UUID.fromString(id2), "chris_martin");
//
//        //when
//        MockHttpServletResponse result = mockMvc.perform(
//                        delete("/api/v1/users/chris_martin/followings")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content("{   \n" +
//                                        "    \"userId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\",\n" +
//                                        "    \"toFollowId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\"\n" +
//                                        "}")
//                                .characterEncoding("utf-8")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andReturn().getResponse();
//
//        //then
//        verify(userService, times(1)).deleteFollowingsByids(UUID.fromString(id), UUID.fromString(id2), "chris_martin");
//        assertThat(result.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
//    }

}