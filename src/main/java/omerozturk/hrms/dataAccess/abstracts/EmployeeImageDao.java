package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.EmployeeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeImageDao extends JpaRepository<EmployeeImage,Integer> {
    List<EmployeeImage> getAllByEmployeeId(int employeeId);
}
