package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.dtos.EmployeeForRegisterDto;
import omerozturk.hrms.entities.concretes.dtos.EmployerForRegisterDto;

public interface AuthService {
    Result registerForEmployee(EmployeeForRegisterDto employeeDto);
    Result registerForEmployer(EmployerForRegisterDto employerDto);
}
