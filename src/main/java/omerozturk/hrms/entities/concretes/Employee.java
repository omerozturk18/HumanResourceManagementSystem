package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import omerozturk.hrms.core.entities.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Employees")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes,employeeImages"})
public class Employee extends User {
    private String firstName;
    private String lastName;
    private String nationalityIdent;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "employee")
    private List<Resume> resumes;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeImage> employeeImages;
}
