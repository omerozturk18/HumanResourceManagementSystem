package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import omerozturk.hrms.core.entities.User;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SystemUsers")
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends User {

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="Roles")
    private String roles;
}
