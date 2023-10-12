package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.config.AppConfig;
import com.ToorenRomaros.api.dto.user.UserAddRequestDto;
import com.ToorenRomaros.api.dto.user.UserDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.RestApiErrorHandler;
import com.ToorenRomaros.api.services.UserService;
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
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
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
    @InjectMocks
    private UserController userController;
    private ModelMapper modelMapper;
    private static final String id = "a1b9b31d-e73c-4112-af7c-b68530f38222";
    private JacksonTester<UserDto> UserDtoTester;

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
               LocalDate.now(),"I love coding",0,0);

        given(userService.createUser(any(UserAddRequestDto.class))).willReturn(modelMapper.map(user, UserDto.class));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.format("{\n" +
                                        "    \"username\": \"montelukas\",\n" +
                                        "    \"birthday\": \"1992-08-12\",\n" +
                                        "    \"createdDate\":\"%s\",\n" +
                                        "    \"about\": \"I love coding\",\n" +
                                        "    \"followingCount\":0,\n" +
                                        "    \"followmeCount\": 0\n" +
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
        JSONAssert.assertEquals(expected, jsonData, false);
    }
    @Test
    @DisplayName("Get user by id")
    void getUserByIdShouldWork() throws Exception {
        //given
        UserEntity user1 = new UserEntity(
                "montelukas", LocalDate.of(1990, 5, 8),
                LocalDate.now(), "I love coding", 0, 0);

        given(userService.getUserById(any(UUID.class))).willReturn(modelMapper.map(user1, UserDto.class));

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
        UserEntity user1 = new UserEntity(
                "montelukas alter", LocalDate.of(1990, 5, 8),
                LocalDate.now(), "I hate coding", 0, 0);

        given(userService.updateUser(any(UUID.class),  any(UserAddRequestDto.class), any(String.class))).willReturn(modelMapper.map(user1, UserDto.class));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                        put("/api/v1/users/montelukas/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{   \n" +
                                        "    \"username\": \"montelukas alter\",\n" +
                                        "    \"about\":  \"I hate coding\"\n" +
                                        "}")
                                .characterEncoding("utf-8")
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();

        //then
        JSONObject jsonObject = new JSONObject(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String expected = jsonObject.get("updated").toString();
        JSONObject jsonData = new JSONObject(UserDtoTester.write(modelMapper.map(user1, UserDto.class)).getJson());
        JSONAssert.assertEquals(expected, jsonData, false);
    }
    @Test
    @DisplayName("Delete user by id")
    void deleteUserByIdWhenIdExists() throws Exception {
        //given
        willDoNothing().given(userService).deleteUserById(any(UUID.class));

        //when
        ResultActions result = mockMvc.perform(
                delete("/api/v1/users/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        //then
        verify(userService, times(1)).deleteUserById(UUID.fromString(id));
        result.andExpect(status().isAccepted());
    }

    //exceptions
    @Test
    @DisplayName("Create user by invalid entity, should throw MethodArgumentNotValidException")
    public void createUserWithInvalidEntityShouldThrowException() throws Exception {
        //when
        try {
            mockMvc.perform(
                            post("/api/v1/users")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(String.format("{   \n" +
                                            "    \"username\": \"montelukas\",\n" +
                                            "    \"birthday\":  \"1992-08-12\",\n" +
                                            "    \"createdDate\": \"%s\",\n" +
                                            "    \"about\": \"I love coding\",\n" +
                                            "    \"followingCount\":0,\n" +
                                            "    \"followmeCount\": -5\n" +
                                            "}", LocalDate.now()))
                                    .characterEncoding("utf-8")
                                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andReturn().getResponse();
        } catch (Exception ex) {
            //then
            assertThat(ex.getMessage()).contains("following me count can not be negative");
            assertThat(ex).isInstanceOf(MethodArgumentNotValidException.class);
        }
    }
    @Test
    @DisplayName("Update user by given id and invalid entity, should throw MethodArgumentNotValidException")
    public void updateUserByWithInvalidEntityShouldThrowException() throws Exception {
        //when
        try {
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
        } catch (Exception ex) {
            //then
            assertThat(ex.getMessage()).contains("birthday must be past");
            assertThat(ex).isInstanceOf(MethodArgumentNotValidException.class);
        }
    }
}