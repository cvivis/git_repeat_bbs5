package com.example.repeat_mustache.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hospital_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalReviewId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "id")
    private Hospital hospital;

    public HospitalReview(String content, Hospital hospital) {
        this.content = content;
        this.hospital = hospital;
    }
}
