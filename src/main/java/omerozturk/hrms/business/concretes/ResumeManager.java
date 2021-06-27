package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.*;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.ResumeDao;
import omerozturk.hrms.entities.concretes.*;
import omerozturk.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;


    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }
    @Override
    public Result add(ResumeDto resumeDto) {
        var employee = new Employee();
        employee.setId(resumeDto.getEmployeeId());
        var resume = new Resume();
        resume.setEmployee(employee);
        resume.setDescription(resumeDto.getDescription());
        resume.setGithubAddress(resumeDto.getGithubAddress());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        this.resumeDao.save(resume);
        return new SuccessResult();
    }
    @Override
    public Result update(ResumeDto resumeDto) {
        Resume resume= resumeDao.getById(resumeDto.getId());

        resume.setDescription(resumeDto.getDescription());
        resume.setGithubAddress(resumeDto.getGithubAddress());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());

        this.resumeDao.save(resume);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(this.resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> getById(int resumeId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getById(resumeId));
    }
    @Override
    public DataResult<Resume> getByEmployeeIdAndDate(int employeeId) {
        List<Resume> resumes=resumeDao.getAllByEmployeeIdOrderByDateOfResumeDesc(employeeId);
        return new SuccessDataResult<Resume>(resumes.get(0));
    }
}
