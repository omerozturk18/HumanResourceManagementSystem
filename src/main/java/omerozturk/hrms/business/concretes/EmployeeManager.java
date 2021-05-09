package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployeeService;
import omerozturk.hrms.business.abstracts.UserService;
import omerozturk.hrms.dataAccess.abstracts.EmployeeDao;
import omerozturk.hrms.dataAccess.abstracts.UserDao;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
