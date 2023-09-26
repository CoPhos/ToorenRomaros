package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.config.AppConfig;
import com.ToorenRomaros.api.dto.UserDto;
import com.ToorenRomaros.api.dto.UserFollowerDto;
import com.ToorenRomaros.api.entities.UserEntity;
import com.ToorenRomaros.api.entities.UserFollowerEntity;
import com.ToorenRomaros.api.exeptions.RestApiErrorHandler;
import com.ToorenRomaros.api.models.User;
import com.ToorenRomaros.api.services.UserService;
import com.ToorenRomaros.api.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UserService userService;
    @Mock
    private MessageSource messageSource;
    @Mock
    private Page<User> userPage;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @InjectMocks
    private UserController userController;
    private final User model = new User();
    private Pageable pageRequest;
    private JacksonTester<List<User>> UserTester;
    private JacksonTester<UserEntity> UserEntityTester;
    private JacksonTester<UserDto> UserDtoTester;

    private JacksonTester<UserFollowerDto> userFollowerDtoTester;
    private ModelMapper modelMapper;
    private static final String id = "a1b9b31d-e73c-4112-af7c-b68530f38222";
    private static final String id2 = "6f95b5af-4d6f-448c-8f3d-ca54521f4653";
    @BeforeEach
    public void setup() {
        ObjectMapper mapper = new AppConfig().objectMapper();
        this.modelMapper = new AppConfig().modelMapper();
        JacksonTester.initFields(this, mapper);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(mapper);

        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new RestApiErrorHandler(messageSource))
                .setMessageConverters(mappingJackson2HttpMessageConverter)
                .build();
    }

    @Test
    @DisplayName("Create user by given user entity")
    void createUserShouldWork() throws Exception{
        //given
        UserEntity user = new UserEntity(
                "montelukas",LocalDate.of(1990,5,8),
                LocalDate.of(2023,9,16),"I love coding",
                0,0, new ArrayList<>(),new ArrayList<>());
        given(userService.createUser(user)).willReturn(new UserDto("montelukas",
                LocalDate.of(1990,5,8),LocalDate.of(2023,9,16),
                "I love coding",0,0, new ArrayList<>(),new ArrayList<>()));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.format("{   \n" +
                                        "    \"username\": \"montelukas\",\n" +
                                        "    \"birthday\":  \"1992-08-12\",\n" +
                                        "    \"createdDate\": \"%s\",\n" +
                                        "    \"about\": \"I love coding\",\n" +
                                        "    \"followingCount\":0,\n" +
                                        "    \"followmeCount\": 0,\n" +
                                        "    \"followers\": null,\n" +
                                        "    \"followings\": null\n" +
                                        "}", LocalDate.now()))
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String expected = jsonObject.get("created").toString();
        JSONObject jsonData = new JSONObject(UserDtoTester.write(modelMapper.map(user, UserDto.class)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("Get user by id")
    void getUserByIdShouldWork() throws Exception{
        //given
        UserEntity user1 = new UserEntity(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"),
                "montelukas",LocalDate.of(1990,5,8),LocalDate.of(2023,9,16),"I love coding",0,0, new ArrayList<>(),new ArrayList<>());
        UserEntity user2 = new UserEntity(
                "Enapril",
                LocalDate.of(1990, 5, 8),
                LocalDate.of(2023, 9, 16),
                "I love pot", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());
        UserEntity user3 = new UserEntity(
                "Benzafibrato",
                LocalDate.of(1990, 5, 8),
                LocalDate.of(2023, 9, 16),
                "I love EDM Music", 0, 0, new ArrayList<UserFollowerEntity>(), new ArrayList<UserFollowerEntity>());

        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now() ,user1, user3);
        UserFollowerEntity userFollowerEntity2 = new UserFollowerEntity(LocalDate.now() ,user1, user2);
        UserFollowerEntity userFollowerEntity3 = new UserFollowerEntity(LocalDate.now() ,user3, user1);
        user1.setFollowers(List.of(userFollowerEntity, userFollowerEntity2));
        user1.setFollowings(List.of(userFollowerEntity3));

        given(userService.getUserById(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"))).willReturn(modelMapper.map(user1, UserDto.class));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        JSONObject jsonObject = new JSONObject(response.getContentAsString());

        String expected = jsonObject.get("response").toString();
        JSONObject jsonData = new JSONObject(UserDtoTester.write(modelMapper.map(user1, UserDto.class)).getJson());
        JSONAssert.assertEquals(expected, jsonData, false);
    }
    @Test
    @DisplayName("Update user by given id and valid entity")
    void updateUserByIdShouldWork() throws Exception {
        UserEntity user = new UserEntity("montelukas",
                LocalDate.of(1992,8,12),LocalDate.now(),
                "I love coding",0,0, new ArrayList<>(),new ArrayList<>());
        given(userService.updateUser(UUID.fromString(id), user)).willReturn(new UserDto("montelukas",LocalDate.of(1992,8,12),LocalDate.now(),"I love coding",0,0, new ArrayList<>(),new ArrayList<>()));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        put("/api/v1/users/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.format("{   \n" +
                                        "    \"username\": \"montelukas\",\n" +
                                        "    \"birthday\":  \"1992-08-12\",\n" +
                                        "    \"createdDate\": \"%s\"\n" +
                                        "}", LocalDate.now()))
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String expected = jsonObject.get("updated").toString();
        JSONObject jsonData = new JSONObject(UserDtoTester.write(modelMapper.map(user, UserDto.class)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("Update user by given id and invalid entity, should throw MethodArgumentNotValidException")
    public void updateUserByWithInvalidEntityShouldThrowException() throws Exception{
        //when
        try{
            MockHttpServletResponse response = mockMvc.perform(
                            put("/api/v1/users/{id}", id)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(String.format("{   \n" +
                                            "    \"username\": \"montelukas\",\n" +
                                            "    \"birthday\":  \"2050-08-12\",\n" +
                                            "    \"createdDate\": \"%s\"\n" +
                                            "}", LocalDate.now()))
                                    .characterEncoding("utf-8")
                                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andReturn().getResponse();
        }catch (Exception ex){
            //then
            assertThat(ex.getMessage()).contains("birthday must be past");
            assertThat(ex).isInstanceOf(MethodArgumentNotValidException.class);
        }
    }
    @Test
    @DisplayName("Delete user by id")
    void deleteUserByIdWhenIdExists() throws Exception {
        //given
        willDoNothing().given(userService).deleteUserById(UUID.fromString(id));

        //when
        ResultActions result = mockMvc.perform(
                delete("/api/v1/users/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        //then
        verify(userService, times(1)).deleteUserById(UUID.fromString(id));
        result.andExpect(status().isAccepted());
    }
    @Test
    @DisplayName("Create user by invalid entity, should throw MethodArgumentNotValidException")
    public void createUserWithInvalidEntityShouldThrowException() throws Exception{
        //when
        try{
            mockMvc.perform(
                            post("/api/v1/users")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(String.format("{   \n" +
                                            "    \"username\": \"montelukas\",\n" +
                                            "    \"birthday\":  \"1992-08-12\",\n" +
                                            "    \"createdDate\": \"%s\",\n" +
                                            "    \"about\": \"I love coding\",\n" +
                                            "    \"followingCount\":0,\n" +
                                            "    \"followmeCount\": -5,\n" +
                                            "    \"followers\": null,\n" +
                                            "    \"followings\": null\n" +
                                            "}", LocalDate.now()))
                                    .characterEncoding("utf-8")
                                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andReturn().getResponse();
        }catch (Exception ex){
            //then
            assertThat(ex.getMessage()).contains("following me count can not be negative");
            assertThat(ex).isInstanceOf(MethodArgumentNotValidException.class);
        }
    }

    @Test
    @DisplayName("returns followers by given user ID")
    void getAllUserFollowersByUserShouldWork() throws Exception {
        UserEntity follower1 = new UserEntity();
        follower1.setId(UUID.randomUUID());
        follower1.setUsername("David");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"));
        userEntity.setUsername("alice");

        UserFollowerEntity userFollowerEntity = new UserFollowerEntity();
        userFollowerEntity.setId(UUID.randomUUID());
        userFollowerEntity.setFollower(follower1);
        userFollowerEntity.setFollowDate(LocalDate.now());
        userFollowerEntity.setUser(userEntity);
        BeanUtils.copyProperties(userFollowerEntity, model);
//        model.setUsername(userFollowerEntity.getFollower().getUsername());
//        model.setFollowDate(userFollowerEntity.getFollowDate());

        pageRequest = PageRequest.of(0,2);
        userPage = new PageImpl<>(List.of(model), pageRequest, List.of(model).size());
        //given
        given(userService.getAllFollowersByUserId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), pageRequest)).willReturn(userPage);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640/followers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(jsonObject.get("totalPages")).isEqualTo(1);
        assertThat(jsonObject.get("totalItems")).isEqualTo(1);
        assertThat(jsonObject.get("currentPage")).isEqualTo(0);
        assertThat(jsonObject.get("followers")).isNotNull();

        String expected = jsonObject.get("followers").toString();
        JSONArray jsonData = new JSONArray(UserTester.write(List.of(model)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("returns followings by given user ID")
    void getAllUserFollowingsByUserShouldWork() throws Exception {
        UserEntity follower1 = new UserEntity();
        follower1.setId(UUID.randomUUID());
        follower1.setUsername("David");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"));
        userEntity.setUsername("alice");

        UserFollowerEntity userFollowerEntity = new UserFollowerEntity();
        userFollowerEntity.setId(UUID.randomUUID());
        userFollowerEntity.setFollower(userEntity);
        userFollowerEntity.setFollowDate(LocalDate.now());
        userFollowerEntity.setUser(follower1);
        BeanUtils.copyProperties(userFollowerEntity, model);
//        model.setUsername(userFollowerEntity.getFollower().getUsername());
//        model.setFollowDate(userFollowerEntity.getFollowDate());

        pageRequest = PageRequest.of(0,2);
        userPage = new PageImpl<>(List.of(model), pageRequest, List.of(model).size());
        //given
        given(userService.getAllFollowingsByUserId(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"), pageRequest)).willReturn(userPage);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/users/b7a61937-6f59-4bbb-80a7-08d65d1ad640/followings")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(jsonObject.get("totalPages")).isEqualTo(1);
        assertThat(jsonObject.get("totalItems")).isEqualTo(1);
        assertThat(jsonObject.get("currentPage")).isEqualTo(0);
        assertThat(jsonObject.get("followings")).isNotNull();

        String expected = jsonObject.get("followings").toString();
        JSONArray jsonData = new JSONArray(UserTester.write(List.of(model)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("create and add follower to user")
    void createFollowerShouldWork() throws Exception {
        //given
        UserEntity follower1 = new UserEntity();
        follower1.setId(UUID.fromString("a1b9b31d-e73c-4112-af7c-b68530f38222"));
        follower1.setUsername("sara_wilson");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.fromString("6f95b5af-4d6f-448c-8f3d-ca54521f4653"));
        userEntity.setUsername("chris_martin");
        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(), userEntity,follower1 );

        given(userService.addFollowerByIds(UUID.fromString(id), UUID.fromString(id2))).willReturn(new UserFollowerDto("chris_martin", LocalDate.now()));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        post("/api/v1/users/followers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"userId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\",\n" +
                                        "    \"toFollowId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String expected = jsonObject.get("created").toString();
        JSONObject jsonData = new JSONObject(userFollowerDtoTester.write(modelMapper.map(userFollowerEntity, UserFollowerDto.class)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("create and add following to user")
    void createFollowingShouldWork() throws Exception {
        //given
        UserEntity follower1 = new UserEntity();
        follower1.setId(UUID.fromString("a1b9b31d-e73c-4112-af7c-b68530f38222"));
        follower1.setUsername("sara_wilson");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.fromString("6f95b5af-4d6f-448c-8f3d-ca54521f4653"));
        userEntity.setUsername("chris_martin");
        UserFollowerEntity userFollowerEntity = new UserFollowerEntity(LocalDate.now(),follower1,userEntity);

        given(userService.addFollowingsByIds(UUID.fromString(id), UUID.fromString(id2))).willReturn(new UserFollowerDto("sara_wilson", LocalDate.now()));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        post("/api/v1/users/followings")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"userId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\",\n" +
                                        "    \"toFollowId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String expected = jsonObject.get("created").toString();
        JSONObject jsonData = new JSONObject(userFollowerDtoTester.write(modelMapper.map(userFollowerEntity, UserFollowerDto.class)).getJson());
        JSONAssert.assertEquals(expected,jsonData, false);
    }

    @Test
    @DisplayName("delete a follower from user")
    void deleteFollowerShouldWork() throws Exception {
        //given
        willDoNothing().given(userService).deleteFollowerByids(UUID.fromString(id), UUID.fromString(id2));

        //when
        MockHttpServletResponse result = mockMvc.perform(
                        delete("/api/v1/users/followers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"userId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\",\n" +
                                        "    \"toFollowId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        verify(userService, times(1)).deleteFollowerByids(UUID.fromString(id), UUID.fromString(id2));
        assertThat(result.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
    }

    @Test
    @DisplayName("delete a following from user")
    void deleteFollowingShouldWork() throws Exception {
        //given
        willDoNothing().given(userService).deleteFollowingsByids(UUID.fromString(id), UUID.fromString(id2));

        //when
        MockHttpServletResponse result = mockMvc.perform(
                        delete("/api/v1/users/followings")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"userId\": \"6f95b5af-4d6f-448c-8f3d-ca54521f4653\",\n" +
                                        "    \"toFollowId\": \"a1b9b31d-e73c-4112-af7c-b68530f38222\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        verify(userService, times(1)).deleteFollowingsByids(UUID.fromString(id), UUID.fromString(id2));
        assertThat(result.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
    }
}