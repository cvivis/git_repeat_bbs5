package com.example.repeat_mustache.domain.entity;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;
    private String businessTypeName;

    private Integer businessStatusCode;

//    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
//    private List<HospitalReview> reviews;

    public Integer getId() {
        return id;
    }

    public String getRoadNameAddress() {
        return roadNameAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public Integer getPatientRoomCount() {
        return patientRoomCount;
    }

    public Integer getTotalNumberOfBeds() {
        return totalNumberOfBeds;
    }

    public Float getTotalAreaSize() {
        return totalAreaSize;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public static HospitalResponse of(Hospital hospital){
        return new HospitalResponse(hospital.getId(), hospital.getRoadNameAddress(),hospital.getHospitalName(),hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(),hospital.getBusinessTypeName(),hospital.getTotalAreaSize() );
    }

    public Integer getBusinessStatusCode() {
        return businessStatusCode;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", roadNameAddress='" + roadNameAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", patientRoomCount=" + patientRoomCount +
                ", totalNumberOfBeds=" + totalNumberOfBeds +
                ", totalAreaSize=" + totalAreaSize +
                ", businessTypeName='" + businessTypeName + '\'' +
                '}';
    }
}