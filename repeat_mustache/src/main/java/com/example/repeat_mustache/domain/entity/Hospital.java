package com.example.repeat_mustache.domain.entity;

import com.example.repeat_mustache.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY) // mappedBy를 통해 외래키 관리를 한쪽에서 위임한다.
    @ToString.Exclude // 없으면 순환참조가 발생할 수도 있다.
    private List<HospitalReview> reviews;

    public List<HospitalReview> getReviews() {
        return reviews;
    }

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
        return new HospitalResponse(hospital.getId(), hospital.getRoadNameAddress(),hospital.getHospitalName(),hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(),hospital.getBusinessTypeName(),hospital.getTotalAreaSize(),hospital.getReviews());
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