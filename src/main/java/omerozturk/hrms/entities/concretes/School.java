package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolName;
    private String sectionName;
    private LocalDate startingDate;
    private LocalDate dateOfGraduation;

    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;


}
