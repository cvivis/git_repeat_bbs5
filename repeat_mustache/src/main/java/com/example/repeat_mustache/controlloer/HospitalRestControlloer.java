package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/hospitals") //
public class HospitalRestControlloer {

    private final HospitalRepository hospitalRepository;

    public HospitalRestControlloer(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return ResponseEntity.ok().body(Hospital.of(hospital.get()));
    }
}
