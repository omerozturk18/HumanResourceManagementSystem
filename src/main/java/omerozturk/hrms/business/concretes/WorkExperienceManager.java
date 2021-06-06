package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.WorkExperienceService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.WorkExperienceDao;
import omerozturk.hrms.entities.concretes.WorkExperience;
import omerozturk.hrms.entities.dtos.WorkExperienceDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    private WorkExperienceDao workExperienceDao;
    private ModelMapper modelMapper;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao, ModelMapper modelMapper) {
        this.workExperienceDao = workExperienceDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public Result add(List<WorkExperienceDto> workExperienceDtos) {
        List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
        for (WorkExperienceDto workExperienceDto : workExperienceDtos){
            workExperiences.add(modelMapper.map(workExperienceDto,WorkExperience.class));
        }
        workExperienceDao.saveAll(workExperiences);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkExperience>> getByBusinessDate(int employeeId) {
        return new SuccessDataResult<List<WorkExperience>>(workExperienceDao.getByBusinessDate(employeeId));

    }
}
