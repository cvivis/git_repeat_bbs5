package com.example.springjpa.controller;

import com.example.springjpa.dto.GetUserRes;
import com.example.springjpa.dto.PostUserReq;
import com.example.springjpa.dto.PostUserRes;
import com.example.springjpa.entity.User;
import com.example.springjpa.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("id로 조회하기")
    void getUserById() throws Exception {
        GetUserRes user = GetUserRes.builder()
                .id(1L)
                .userName("sjsj")
                .build();
        given(userService.getUserById(user.getId())).willReturn(user);
        long userId = 1L;
        String url = String.format("/api/v1/users/%d", userId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("sjsj"))
                .andExpect(jsonPath("$.id").value(1L))
                .andDo(print());

        verify(userService).getUserById(userId);
    }

    @Test
    @DisplayName("post user")
    void addUser() throws Exception {
        Map<PostUserReq, PostUserRes> map = new HashMap<>();
        PostUserReq user = PostUserReq.builder()
                .userName("빰빰")
                .password("1234")
                .build();

        PostUserRes userRes = PostUserRes.builder()
                .userName(user.getUserName())
                .message("중복된 이름입니다.")
                .build();

        PostUserReq user2 = PostUserReq.builder()
                .userName("뿜뿜")
                .password("1234")
                .build();

        PostUserRes userRes2 = PostUserRes.builder()
                .userName(user2.getUserName())
                .message("가입이 완료되었습니다.")
                .build();

        map.put(user, userRes);
        map.put(user2, userRes2);


        for (PostUserReq users : map.keySet()) {
            System.out.println(map.get(users));

            String str = objectMapper.writeValueAsString(users);
            given(userService.addUser(users)).willReturn(map.get(users));
            String url = String.format("/api/v1/users");
            mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(str))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.userName").value(map.get(users).getUserName()))
                    .andExpect(jsonPath("$.message").value(map.get(users).getMessage()))
                    .andDo(print());

            verify(userService).addUser(users);
        }
    }
}