package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.JobPositionService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.JobPositionDao;

import omerozturk.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Eklendi");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return new SuccessResult(" Silindi");
    }

    @Override
    public DataResult<Optional<JobPosition>> getById(int jobPositionId) {
        return new SuccessDataResult<Optional<JobPosition>>(jobPositionDao.findById(jobPositionId),"Veri Listelendi");
    }
}
