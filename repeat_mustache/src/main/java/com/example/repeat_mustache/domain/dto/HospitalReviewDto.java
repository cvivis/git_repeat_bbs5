package com.example.repeat_mustache.domain.dto;

import com.example.repeat_mustache.domain.entity.Article;
import com.example.repeat_mustache.domain.entity.Comment;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.domain.entity.HospitalReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@Builder
public class HospitalReviewDto {
    private Long HospitalReviewId;
    private String content;

    private Hospital hospital;

    public HospitalReview toEntity(){
        return new HospitalReview(this.content,this.hospital);
    }

    @Override
    public String toString() {
        return "HospitalReviewDto{" +
                "HospitalReviewId=" + HospitalReviewId +
                ", content='" + content + '\'' +
                ", hospital=" + hospital +
                '}';
    }

    //    public Comment toEntityComment() {
//        return new Comment(this.);
//    }



}
