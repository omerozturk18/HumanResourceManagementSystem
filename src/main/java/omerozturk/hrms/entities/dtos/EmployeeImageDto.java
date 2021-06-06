package omerozturk.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeImageDto {
    private int id;
    private String url;
    private LocalDate uploadedAt;
    private int employeeId;
}