package omerozturk.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {

    private int id;
    private int resumeId;
    private String schoolName;
    private String sectionName;
    private LocalDate startingDate;
    private LocalDate dateOfGraduation;
}
