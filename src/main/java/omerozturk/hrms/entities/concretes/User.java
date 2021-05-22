package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
