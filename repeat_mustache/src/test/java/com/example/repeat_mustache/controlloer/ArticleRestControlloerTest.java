package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.ArticleAddReq;
import com.example.repeat_mustache.domain.dto.ArticleAddRes;
import com.example.repeat_mustache.domain.dto.ArticleDto;
import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.service.ArticleService;
import com.example.repeat_mustache.service.HospitalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControlloerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Autowired
    ObjectMapper objectMapper;

//    private fun <T> any(): T {
//        Mockito.any<T>()
//        return null as T
//    }

    @Test
    @DisplayName("1개의 Json 형태로 Res 가 잘 오는지")
        //id: '6', content '내용이 넣깅', title '우왕'
    void jsonTest() throws Exception {
        ArticleDto articleDto = ArticleDto.builder()
                .id(6L)
                .content("내용이 넣깅")
                .title("우왕")
                .build();
        given(articleService.getArticle(articleDto.getId())).willReturn(articleDto);
        Long articleId = 6L;
        String url = String.format("/api/v1/articles/%d",articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").value("내용이 넣깅"))
                .andDo(print());//http request, reponse 내역 출력

        verify(articleService).getArticle(articleId);
    }

    @Test
    @DisplayName("add 테스트")
        //id: '6', content '내용이 넣깅', title '우왕'
    void addTest() throws Exception {
        ArticleAddReq articleAddReq = new ArticleAddReq("test1", "test1");
        ArticleAddRes articleAddRes = new ArticleAddRes(23l,articleAddReq.getTitle(), articleAddReq.getContent());

        given(articleService.addArticle(any())).willReturn(articleAddRes);

        String str= objectMapper.writeValueAsString(articleAddReq);
        System.out.println("str: "+str);
        String url = String.format("/api/v1/articles");
        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(str))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("test1"))
                .andExpect(jsonPath("$.content").value("test1"))
                .andDo(print());

        verify(articleService).addArticle(articleAddReq);

    }
}