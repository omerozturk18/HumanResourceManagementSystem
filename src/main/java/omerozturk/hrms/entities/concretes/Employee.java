package omerozturk.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="NationalityIdent")
    private String nationalityIdent;

    @Column(name="BirthDate")
    private Date birthDate;

    @Column(name="Status")
    private boolean status;
}
