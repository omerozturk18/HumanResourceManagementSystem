package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    Employee getById(int employeeId);

}
