package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.EmployeeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeImageDao extends JpaRepository<EmployeeImage,Integer> {
}
