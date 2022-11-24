package com.example.repeat_mustache.domain.dto;

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
public class HospitalReviewRes {
    private Long HospitalReviewId;
    private String content;
}
