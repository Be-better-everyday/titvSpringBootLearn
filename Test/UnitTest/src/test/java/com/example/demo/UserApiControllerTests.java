package com.example.demo;

import com.example.demo.controller.UserApiController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserApiController.class)
public class UserApiControllerTests {

    private static final String END_POINT_PATH = "/users";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService service;

    @Test
    public void testAddShouldReturn400BadRequest() throws Exception {
        User newUser = new User().email("").firstName("");

        String requestBody = objectMapper.writeValueAsString(newUser);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testAddShouldReturn201Created() throws Exception {
        User newUser = new User().email("dao2@gmail.com")
                .firstName("dao").lastName("Nh")
                .password("dao");

        Mockito.when(service.add(newUser)).thenReturn(newUser.id(1L));

        String requestBody = objectMapper.writeValueAsString(newUser);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andDo(print());
    }

//    @Test
//    public void testGetShouldReturn200Ok() throws Exception {
//        User
//
//        String requestBody = objectMapper.writeValueAsString(newUser);
//
//        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isBadRequest())
//                .andDo(print());
//    }
}
