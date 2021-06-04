package omerozturk.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {

    private int id;
    private int employeeId;
    private String description;
    private String githubAddress;
    private String linkedinAddress;

}