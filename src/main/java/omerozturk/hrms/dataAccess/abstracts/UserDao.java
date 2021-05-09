package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
