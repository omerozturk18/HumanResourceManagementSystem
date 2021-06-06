package omerozturk.hrms.core.dataAccess;

import omerozturk.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getById(int userId);
}
