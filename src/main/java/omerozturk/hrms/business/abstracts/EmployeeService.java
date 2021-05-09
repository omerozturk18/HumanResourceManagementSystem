package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
}
