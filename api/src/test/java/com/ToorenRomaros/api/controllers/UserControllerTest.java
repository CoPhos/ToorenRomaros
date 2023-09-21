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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
    private ModelMapper modelMapper;

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

        final Instant now = Instant.now();
    }

    @Test
    @DisplayName("Create user by given user")
    void createUserShouldWork() throws Exception{
        //given
        UserEntity user = new UserEntity(
                "montelukas",LocalDate.of(1990,5,8),LocalDate.of(2023,9,16),"I love coding",0,0, null,null);
        given(userService.createUser(user)).willReturn(new UserDto("montelukas",LocalDate.of(1990,5,8),LocalDate.of(2023,9,16),"I love coding",0,0, null,null));

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
        JSONObject jsonData = new JSONObject(UserEntityTester.write(user).getJson());
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

        given(userService.getUser(UUID.fromString("b7a61937-6f59-4bbb-80a7-08d65d1ad640"))).willReturn(modelMapper.map(user1, UserDto.class));

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
    @DisplayName("Create user by invalid entity, should throw MethodArgumentNotValidException")
    public void createUserWithInvalidEntityShouldThrowException() throws Exception{
        //when
        try{
            mockMvc.perform(
                            post("/api/v1/users")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{   \n" +
                                            "    \"username\": \"montelukas\",\n" +
                                            "    \"birthday\":  \"1992-08-12\",\n" +
                                            "    \"createdDate\": \"2023-09-16\",\n" +
                                            "    \"about\": \"I love coding\",\n" +
                                            "    \"followingCount\":0,\n" +
                                            "    \"followmeCount\": -5,\n" +
                                            "    \"follower\": null,\n" +
                                            "    \"following\": null\n" +
                                            "}")
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
}