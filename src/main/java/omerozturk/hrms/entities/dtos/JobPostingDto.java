package omerozturk.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
    private int id;
    private int employerId;
    private int jobPositionId;
    private int cityId;
    private String jobDescription;
    private double minSalary;
    private double maxSalary;
    private int openPositionCount;
    private Date applicationDeadline;
    private Date releaseDate;
    private boolean status;
}
