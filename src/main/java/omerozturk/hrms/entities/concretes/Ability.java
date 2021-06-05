package omerozturk.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="abilities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String abilityName;
    private String technologyName;

    @ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;



}
