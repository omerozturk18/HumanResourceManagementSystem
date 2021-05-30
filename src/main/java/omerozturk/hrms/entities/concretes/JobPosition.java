package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="JobPositions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="PositionName")
    private String positionName;

    @Column(name="Status")
    private boolean status;
    
     @OneToMany(mappedBy = "jobPosition")
    private List<JobPosting> jobPostings;

}
