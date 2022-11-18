package com.example.repeat_mustache.service;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import com.example.repeat_mustache.domain.entity.Hospital;
import com.example.repeat_mustache.repository.HospitalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HospitalServiceTest {


    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    public void setUpTest(){
        hospitalService = new HospitalService(hospitalRepository);
    }

    //{"id":2,"roadNameAddress":"광주광역시 북구 설죽로 518, 2층 (일곡동)","hospitalName":"일곡부부치과의원","patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"치과의원","totalAreaSize":200.0,"businessStatusCodeName":"영업중"}
    @Test
    void getHospital() {
        int id = 2;

        Hospital res = Hospital.builder()
                .id(2)
                .roadNameAddress("광주광역시 북구 설죽로 518, 2층 (일곡동)")
                .hospitalName("일곡부부치과의원")
                .patientRoomCount(0)
                .businessTypeName("치과의원")
                .totalAreaSize(200.0F)
                .totalNumberOfBeds(0)
                .businessStatusCode(13)
                .build();

        Hospital res1 = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(res1));
        HospitalResponse closedHospitalResponse = hospitalService.getHospital(71857);
        assertEquals("폐업", closedHospitalResponse.getBusinessStatusCodeName());

        Mockito.when(hospitalRepository.findById(id)).thenReturn(Optional.of(res)); // repository 코드 확인
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        Assertions.assertEquals(hospitalResponse.getBusinessStatusCodeName(),"영업중"); // 서비스 확인
        verify(hospitalRepository).findById(id);

    }
}