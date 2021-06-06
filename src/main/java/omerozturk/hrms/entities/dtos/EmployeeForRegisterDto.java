package omerozturk.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeForRegisterDto {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalityIdent;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String verifyPassword;
    private boolean status=true;
}