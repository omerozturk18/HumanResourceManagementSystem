package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployerService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.EmployerDao;
import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult(" Eklendi");
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult(" Silindi");
    }

    @Override
    public DataResult<Employer> getById(int employerId) {
        return new SuccessDataResult<Employer>(employerDao.getById(employerId),"Veri Listelendi");
    }
}
