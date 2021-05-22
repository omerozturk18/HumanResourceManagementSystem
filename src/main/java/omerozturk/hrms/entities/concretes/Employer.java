package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name="CompanyName")
    private String companyName;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="VerifedBySystem")
    private boolean verifedBySystem;

    @Column(name="Status")
    private boolean status;
}
