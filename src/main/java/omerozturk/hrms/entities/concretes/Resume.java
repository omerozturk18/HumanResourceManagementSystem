package omerozturk.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String githubAddress;
    private String linkedinAddress;

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
