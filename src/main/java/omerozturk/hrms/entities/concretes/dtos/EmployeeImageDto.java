package omerozturk.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeImageDto {
    private int id;
    private String url;
    private Date uploadedAt;
    private int employeeId;
}