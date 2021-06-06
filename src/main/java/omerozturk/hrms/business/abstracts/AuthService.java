package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.entities.User;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.dtos.EmployeeForRegisterDto;
import omerozturk.hrms.entities.dtos.EmployerForRegisterDto;
import omerozturk.hrms.entities.dtos.UserForLoginDto;

public interface AuthService {
    Result registerForEmployee(EmployeeForRegisterDto employeeDto);
    Result registerForEmployer(EmployerForRegisterDto employerDto);
    Result login(UserForLoginDto userForLoginDto);
}
