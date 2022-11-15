package com.example.repeat_mustache.domain.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder // 순서 상관없이 셋 가능
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
    private String businessStatusCodeName;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, Integer patientRoomCount, Integer totalNumberOfBeds, String businessTypeName, Float totalAreaSize) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.totalAreaSize = totalAreaSize;
    }

    public HospitalResponse(Integer id, String hospitalName, String businessTypeName) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
    }

    public void setBusinessCodeName(String businessStatusCodeName) {
        this.businessStatusCodeName = businessStatusCodeName;
    }
}
