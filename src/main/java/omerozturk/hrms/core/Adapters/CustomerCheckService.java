package omerozturk.hrms.core.Adapters;

import omerozturk.hrms.entities.concretes.Employee;

public interface CustomerCheckService {
    boolean CheckIfRealPerson(Employee employee);
}
