package omerozturk.hrms.entities.concretes;

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
