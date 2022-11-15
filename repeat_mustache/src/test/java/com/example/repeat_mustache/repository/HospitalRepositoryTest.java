package com.example.repeat_mustache.repository;

import com.example.repeat_mustache.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

//    @Test
//    @DisplayName("특정시 찾기")
//    void findByRoadNameAddressContaining() {
//        String roadAdr = "수원시";
//        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining(roadAdr);
//        for (Hospital hospital : hospitals){
//            System.out.println(hospital.getRoadNameAddress() + " "+ hospital.getHospitalName());
//        }
//        System.out.println("-------------------");
//    }

//    @Test
//    @DisplayName("특정시 안의 피부과 찾기")
//    void findByRoadNameAddressContainingAndHospitalNameContaining(){
//        String adr ="수원시";
//        String name = "피부과";
//        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContainingAndHospitalNameContaining(adr,name);
//        for (Hospital hospital : hospitals){
//            System.out.println(hospital.getRoadNameAddress() + " "+ hospital.getHospitalName());
//        }
//        System.out.println("-------------------");
//    }

//    @Test
//    @DisplayName("findBy비지니스")
//    void findByBusinessTypeNameIn() {
//        List<String> inCluds = new ArrayList<>();
//        String adr = "광주시";
//        inCluds.add("보건소");
//        inCluds.add("보건지소");
//        inCluds.add("보건진료소");
//        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContainingAndBusinessTypeNameIn(adr,inCluds);
//        for (Hospital hospital : hospitals){
//            System.out.println(hospital.getBusinessTypeName() + " " + hospital.getRoadNameAddress());
//        }
//        System.out.println("-------------------");
//    }

//    @Test
//    @DisplayName("병상수로 병원 검색")
//    void findByTotalNumberOfBedsBetween() {
//        int num = 10;
//        int num2 = 20;
//        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(num,num2);
//        for (Hospital hospital : hospitals){
//            System.out.println(hospital.getHospitalName() + ": " + hospital.getPatientRoomCount() + " (" + hospital.getRoadNameAddress() + ")");
//        }
//        System.out.println("-------------------");
//    }
}