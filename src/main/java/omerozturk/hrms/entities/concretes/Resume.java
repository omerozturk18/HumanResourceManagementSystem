package omerozturk.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String githubAddress;
    private String linkedinAddress;
    private LocalDate dateOfResume;
    private boolean status;

    @OneToMany(mappedBy = "resume")
    private List<School> schools;

    @OneToMany(mappedBy = "resume")
    private List<Ability> abilities;

    @OneToMany(mappedBy = "resume")
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperiences ;

    @ManyToOne()
    @JoinColumn(name="employee_id")
    private Employee employee;
}
