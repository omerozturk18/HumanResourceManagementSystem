package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="CompanyName")
    private String companyName;

    @Column(name="WebSite")
    private String webSite;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="VerifedBySystem")
    private boolean verifedBySystem=false;

    @Column(name="Status")
    private boolean status=true;
    
     @OneToMany(mappedBy = "employer")
     @JsonIgnore
    private List<JobPosting> jobPostings;
}
