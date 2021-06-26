package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name="FavoriteJobPosting")
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employeeId")
    private int employeeId;

    @ManyToOne()
    @JoinColumn(name="jobPostingId")
    private JobPosting jobPosting;

}

