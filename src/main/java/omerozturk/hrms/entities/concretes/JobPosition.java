package omerozturk.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="JobPositions")
public class JobPosition {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="PositionName")
    private String positionName;

    @Column(name="Status")
    private boolean status;

}
