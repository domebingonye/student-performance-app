package com.dominic.studentperformanceapp.dto.student;

import com.dominic.studentperformanceapp.enums.Subjects;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    @Schema(hidden = true)
    private Long id;
    @NotNull(message = "subject is required")
    private Subjects subject;
    @Max(value = 100, message = "score must not be more than 100")
    private double score;
    private String grade;
    @NotNull(message = "regNo is required")
    private String regNo;
    private String remark;
}
