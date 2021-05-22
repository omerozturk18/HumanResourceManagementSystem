package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployeeService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.EmployeeDao;
import omerozturk.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(Employee employee) {
        employeeDao.save(employee);
        return new SuccessResult(" Eklendi");
    }

    @Override
    public Result delete(Employee employee) {
        employeeDao.delete(employee);
        return new SuccessResult(" Silindi");
    }

    @Override
    public DataResult<Optional<Employee>> getById(int employeeId) {
        return new SuccessDataResult<Optional<Employee>>(employeeDao.findById(employeeId),"Veri Listelendi");
    }
}
