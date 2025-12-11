package com.dominic.studentperformanceapp.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "surname is required")
    private String surname;
    @NotBlank(message = "firstName is required")
    private String firstName;
    private String middleName;
    @NotBlank(message = "level class is required")
    private String level;
    private String regNo;
    @NotBlank(message = "parentEmailAddress is required")
    @Email(message = "Invalid email format")
    private String parentEmailAddress;
}
