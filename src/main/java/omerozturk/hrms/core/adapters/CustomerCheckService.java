package omerozturk.hrms.core.adapters;

import omerozturk.hrms.entities.concretes.Employee;

public interface CustomerCheckService {
    boolean CheckIfRealPerson(Employee employee);
}
