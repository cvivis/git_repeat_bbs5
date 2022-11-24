package com.example.repeat_mustache.repository;

import com.example.repeat_mustache.domain.entity.Comment;
import com.example.repeat_mustache.domain.entity.HospitalReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalReviewRepository extends JpaRepository<HospitalReview, Long> {
    List<HospitalReview> findByHospital_Id(Integer hospitalId);

}
