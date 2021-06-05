package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String workPlaceName;
    private String jobPosition;
    private Date dateOfStart;
    private Date departureDate;

    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;

}
