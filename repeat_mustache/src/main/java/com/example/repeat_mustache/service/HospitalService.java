package com.example.repeat_mustache.service;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService { // 하위 레이어의 의존성을 주입받아야한다. -> dao(repository)
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
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
}
