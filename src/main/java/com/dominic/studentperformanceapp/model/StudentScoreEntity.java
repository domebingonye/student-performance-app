package com.dominic.studentperformanceapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@Entity
@Table(name = "STUDENT_SCORE")
public class StudentScoreEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "SCORE")
    private Double score;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "REG_NO")
    private String regNo;

    @Column(name = "REMARK")
    private String remark;
}
