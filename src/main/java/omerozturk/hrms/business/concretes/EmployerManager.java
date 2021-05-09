package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployerService;
import omerozturk.hrms.business.abstracts.UserService;
import omerozturk.hrms.dataAccess.abstracts.EmployerDao;
import omerozturk.hrms.dataAccess.abstracts.UserDao;
import omerozturk.hrms.entities.concretes.Employer;
import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }
}
