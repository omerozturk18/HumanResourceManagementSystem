package omerozturk.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Email
    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="EmailVerified")
    private boolean emailVerified;

    @Column(name="Status")
    private boolean status;
}
