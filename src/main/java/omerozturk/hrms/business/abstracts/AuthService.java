package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.Employer;
import omerozturk.hrms.entities.concretes.User;

public interface AuthService {
    Result registerForEmployee(User user, Employee employee);
    Result registerForEmployer(User user, Employer employer);
}
