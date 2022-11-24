package com.example.repeat_mustache.service;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.dto.HospitalReviewDto;
import com.example.repeat_mustache.domain.dto.HospitalReviewRes;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.domain.entity.HospitalReview;
import com.example.repeat_mustache.repository.HospitalRepository;
import com.example.repeat_mustache.repository.HospitalReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService { // 하위 레이어의 의존성을 주입받아야한다. -> dao(repository)
    private final HospitalRepository hospitalRepository;
    private final HospitalReviewRepository hospitalReviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, HospitalReviewRepository hospitalReviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalReviewRepository = hospitalReviewRepository;
    }

    public HospitalResponse getHospital(Integer id){
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get();

        HospitalResponse hospitalRes = Hospital.of(hospital);
        if(hospital.getBusinessStatusCode() == 13){
            hospitalRes.setBusinessCodeName("영업중");
        }
        else if (hospital.getBusinessStatusCode() == 3) {
            hospitalRes.setBusinessCodeName("폐업");
        } else {
            hospitalRes.setBusinessCodeName(String.valueOf(hospital.getBusinessStatusCode()));
        }
            return hospitalRes;
    }

    public Page<Hospital> getHospitalList(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }
    public Page<Hospital> findHospitalList(String keyword,Pageable pageable) {
         return hospitalRepository.findByRoadNameAddressContaining(keyword,pageable);
    }

    public long createReviews(Integer id, HospitalReviewDto form) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        System.out.println("ckeck: "+optionalHospital.get().toString());
        form.setHospital(optionalHospital.get());
        System.out.println("form: " + form.toString());
        HospitalReview hospitalReview = form.toEntity();
        HospitalReview saved = hospitalReviewRepository.save(hospitalReview);
        return saved.getHospital().getId();
    }

    public HospitalReviewRes getReviewById(Long id) {
        Optional<HospitalReview> optionalHospitalReview = hospitalReviewRepository.findById(id);
        HospitalReviewRes hospitalReview = HospitalReviewRes.builder()
                .HospitalReviewId(optionalHospitalReview.get().getHospitalReviewId())
                .content(optionalHospitalReview.get().getContent())
                .build();
        return hospitalReview;
    }

    public List<HospitalReviewRes> getReviews(Integer id) {
        List<HospitalReview> listHospitalReview = hospitalReviewRepository.findByHospital_Id(id);
        List<HospitalReviewRes> reviews = new ArrayList<>();
        for(HospitalReview hr: listHospitalReview){
            HospitalReviewRes hospitalReview = HospitalReviewRes.builder()
                    .HospitalReviewId(hr.getHospitalReviewId())
                    .content(hr.getContent())
                    .build();
            reviews.add(hospitalReview);
        }
        return reviews;
    }
}
