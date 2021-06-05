package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class EmployeeImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private Date uploadedAt;

    @ManyToOne()
    @JoinColumn(name="employee_id")
    private Employee employee;

}
