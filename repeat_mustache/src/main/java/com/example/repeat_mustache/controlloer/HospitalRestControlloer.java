package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.repository.HospitalRepository;
import com.example.repeat_mustache.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/hospitals") //
public class HospitalRestControlloer {

//    private final HospitalRepository hospitalRepository; // 의존성 주입 좋지 못한 관계 -> 레이어드 아키텍쳐로 리팩토
//
//    public HospitalRestControlloer(HospitalRepository hospitalRepository) {
//        this.hospitalRepository = hospitalRepository;
//    }
    private final HospitalService hospitalService;
    public HospitalRestControlloer(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalRes = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalRes);
    }
}
