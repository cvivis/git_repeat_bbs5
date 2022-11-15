package com.example.repeat_mustache.repository;

import com.example.repeat_mustache.domain.entity.Hospital;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital>  findByRoadNameAddressContaining(String roadNameAddress, Pageable pageable);

    List<Hospital>  findByRoadNameAddressContainingAndHospitalNameContaining(String roadNameAddress,String hospitalName);

    List<Hospital> findByRoadNameAddressContainingAndBusinessTypeNameIn(String roadNameAddress, List<String> businessTypeName); // In -> list로 들어온 값의 하나라도 일치하면 조회

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int num, int num2);
}
