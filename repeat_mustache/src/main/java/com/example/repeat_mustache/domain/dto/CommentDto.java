package com.example.repeat_mustache.domain.dto;

import com.example.repeat_mustache.domain.entity.Article;
import com.example.repeat_mustache.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class CommentDto {
    private Long commentId;
    private String content;

    private Article article;

    public Comment toEntity(){
        return new Comment(this.article,this.content);
    }

//    public Comment toEntityComment() {
//        return new Comment(this.);
//    }



}
