package omerozturk.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
    private int id;
    private int employer_id;
    private int job_position_id;
    private int city_id;
    private String jobDescription;
    private double minSalary;
    private double maxSalary;
    private int openPositionCount;
    private Date applicationDeadline;
    private Date releaseDate;
    private boolean status;
}
