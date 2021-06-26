package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import omerozturk.hrms.core.entities.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer extends User {
    @Column(name="CompanyName")
    private String companyName;

    @Column(name="WebSite")
    private String webSite;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="VerifiedBySystem")
    private boolean verifiedBySystem =false;

    @Column(name="UpdateVerifiedBySystem")
    private boolean updateVerifiedBySystem =true;

    
    @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
}
