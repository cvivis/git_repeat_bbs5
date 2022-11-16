package com.example.repeat_mustache.domain.dto;

import com.example.repeat_mustache.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ArticleAddReq {
    private String title;
    private String content;

    public Article toEntity(){
        Article article = Article.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
        return article;
    }


    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
