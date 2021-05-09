package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  SystemUserDao extends JpaRepository<SystemUser,Integer> {
}
