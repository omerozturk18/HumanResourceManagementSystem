package omerozturk.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="EmailVerified")
    private boolean emailVerified;

    @Column(name="Status")
    private boolean status;
}
