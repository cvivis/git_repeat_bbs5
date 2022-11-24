package com.example.repeat_mustache.domain.dto;

import com.example.repeat_mustache.domain.entity.HospitalReview;
import lombok.*;

import java.util.List;

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

    private List<HospitalReview> reviews;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, Integer patientRoomCount, Integer totalNumberOfBeds, String businessTypeName, Float totalAreaSize,List<HospitalReview> reviews) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.totalAreaSize = totalAreaSize;
        this.reviews = reviews;
    }
//
//    public HospitalResponse(Integer id, String hospitalName, String businessTypeName) {
//        this.id = id;
//        this.hospitalName = hospitalName;
//        this.businessTypeName = businessTypeName;
//    }

    public void setBusinessCodeName(String businessStatusCodeName) {
        this.businessStatusCodeName = businessStatusCodeName;
    }

    @Override
    public String toString() {
        return "HospitalResponse{" +
                "id=" + id +
                ", roadNameAddress='" + roadNameAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", patientRoomCount=" + patientRoomCount +
                ", totalNumberOfBeds=" + totalNumberOfBeds +
                ", businessTypeName='" + businessTypeName + '\'' +
                ", totalAreaSize=" + totalAreaSize +
                ", businessStatusCodeName='" + businessStatusCodeName + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
