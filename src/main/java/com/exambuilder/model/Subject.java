package com.exambuilder.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public @Data  class Subject {

    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject_name;
    private String status;
    private String createdBy;
    private String createdId;

}
