package com.dominic.studentperformanceapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@Entity
@Table(name = "STUDENT_DETAILS", uniqueConstraints = {@UniqueConstraint(columnNames = "PARENT_EMAIL_ADDRESS")})
public class StudentDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "REG_NO")
    private String regNo;

    @Column(name = "PARENT_EMAIL_ADDRESS")
    private String parentEmailAddress;
}
