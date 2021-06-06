package omerozturk.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {

    private int id;
    private int resumeId;
    private String workPlaceName;
    private String jobPosition;
    private LocalDate dateOfStart;
    private LocalDate departureDate;
}
