package omerozturk.hrms.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeForRegisterDto {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalityId;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String verifyPassword;
}