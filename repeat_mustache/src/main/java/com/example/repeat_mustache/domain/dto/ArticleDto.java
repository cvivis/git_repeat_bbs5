package com.example.repeat_mustache.domain.dto;

import com.example.repeat_mustache.domain.entity.Article;
import lombok.Getter;

@Getter
public class ArticleDto {
//    private Long id;
    private String title;
    private String content;

    public ArticleDto( String title, String content) {
//        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article toEntity(){
        return new Article(this.title,this.content);
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
