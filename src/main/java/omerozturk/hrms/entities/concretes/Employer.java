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
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer {

    @Column(name="CompanyName")
    private String companyName;

    @Column(name="WebSite")
    private String webSite;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="VerifedBySystem")
    private boolean verifedBySystem;

    @Column(name="Status")
    private boolean status;
    
     @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
}
