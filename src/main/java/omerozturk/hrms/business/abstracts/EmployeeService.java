package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result add(Employee employee);
    Result delete(Employee employee);
    DataResult<Optional<Employee>> getById(int employeeId);
}
