package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.AuthService;
import omerozturk.hrms.core.Adapters.CustomerCheckService;
import omerozturk.hrms.core.utilities.result.ErrorResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.EmployeeDao;
import omerozturk.hrms.dataAccess.abstracts.EmployerDao;
import omerozturk.hrms.dataAccess.abstracts.UserDao;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.Employer;
import omerozturk.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private UserDao userDao;
    private EmployeeDao employeeDao;
    private EmployerDao employerDao;
    private CustomerCheckService customerCheckService;

    @Autowired
    public AuthManager(UserDao userDao, EmployeeDao employeeDao, EmployerDao employerDao, CustomerCheckService customerCheckService) {
        this.userDao = userDao;
        this.employeeDao = employeeDao;
        this.employerDao = employerDao;
        this.customerCheckService = customerCheckService;
    }

    @Override
    public Result registerForEmployee(User user,Employee employee) {
        var controlUser=checkUser(user);
        var controlEmployee= checkEmployee(employee);
        if (!controlUser.isSuccess()) return new ErrorResult(controlUser.getMessage());
        if (!controlEmployee.isSuccess()) return new ErrorResult(controlEmployee.getMessage());
        userDao.save(user);
        employeeDao.save(employee);
        return new SuccessResult(" Kimlik Doğrulama Başarılı, Kayıt Başarılı");
    }
    @Override
    public Result registerForEmployer(User user, Employer employer) {
        var controlUser=checkUser(user);
        var controlEmployer= checkEmployer(employer,user);
        if (!controlUser.isSuccess()) return new ErrorResult(controlUser.getMessage());
        if (!controlEmployer.isSuccess()) return new ErrorResult(controlEmployer.getMessage());
        userDao.save(user);
        employerDao.save(employer);
        return new SuccessResult("Kayıt Başarılı");
    }

    private Result checkEmployee(Employee employee){
        for (Employee employeeOfList: employeeDao.findAll()) {
            if (employee.getNationalityIdent().equals(employeeOfList.getNationalityIdent()))return new ErrorResult("Bu kimlik numarası kullanımda.");
        }
        if (!customerCheckService.CheckIfRealPerson(employee)) return new ErrorResult(" Kimlik Doğrulama Başarısız");
        return new SuccessResult();
    }
    private Result checkUser(User user){
        for (User userOfList: userDao.findAll()) {
            if (user.getEmail().equals(userOfList.getEmail()))return new ErrorResult("Bu eposta kullanımda.");
        }
        return new SuccessResult();
    }
    private Result checkEmployer(Employer employer,User user){
        var x=employer.getWebSite().split("www.");
        var y=user.getEmail().split("@");
        if (x[1].equals(y[1])) return new SuccessResult();
        return new ErrorResult("Bu eposta ile domain eşleşmiyor.");
    }
}
