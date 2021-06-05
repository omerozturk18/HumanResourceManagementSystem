package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.*;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.ResumeDao;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.Resume;
import omerozturk.hrms.entities.concretes.dtos.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;
    private EmployeeService employeeService;
    private SchoolService schoolService;
    private ForeignLanguageService foreignLanguageService;
    private AbilityService abilityService;
    private WorkExperienceService workExperienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,EmployeeService employeeService,
                         SchoolService schoolService,ForeignLanguageService foreignLanguageService,
                         AbilityService abilityService,WorkExperienceService workExperienceService) {
        this.resumeDao = resumeDao;
        this.employeeService=employeeService;
        this.schoolService = schoolService;
        this.foreignLanguageService = foreignLanguageService;
        this.abilityService = abilityService;
        this.workExperienceService = workExperienceService;
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
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(this.resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> getByEmployeeForResume(int employeeId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getResumeByEmployeeId(employeeId));
    }
}
