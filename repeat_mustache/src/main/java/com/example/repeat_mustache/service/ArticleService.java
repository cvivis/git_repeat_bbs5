package com.example.repeat_mustache.service;

import com.example.repeat_mustache.domain.dto.ArticleAddReq;
import com.example.repeat_mustache.domain.dto.ArticleAddRes;
import com.example.repeat_mustache.domain.dto.ArticleDto;
import com.example.repeat_mustache.domain.entity.Article;
import com.example.repeat_mustache.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService { // 하위 레이어의 의존성을 주입받아야한다. -> dao(repository)
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public ArticleDto getArticle(Long id){
        Optional<Article> optArticle = articleRepository.findById(id);
        Article articles = optArticle.get();

        ArticleDto article = ArticleDto.builder()
                .id(articles.getId())
                .title(articles.getTitle())
                .content(articles.getContent())
                .build();

        return article;
    }

    public ArticleAddRes addArticle(ArticleAddReq articleAddReq) {
        Article articleEntity = articleAddReq.toEntity();

        Article saved = articleRepository.save(articleEntity);
        ArticleAddRes articleAddRes = ArticleAddRes.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .content(saved.getContent())
                .build();
        return articleAddRes;
    }
}
