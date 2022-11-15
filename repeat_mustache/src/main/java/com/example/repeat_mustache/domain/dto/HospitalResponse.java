package com.example.repeat_mustache.domain.dto;

import lombok.Getter;

@Getter
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;

    public HospitalResponse(Integer id, String hospitalName, String businessTypeName) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
    }
}
