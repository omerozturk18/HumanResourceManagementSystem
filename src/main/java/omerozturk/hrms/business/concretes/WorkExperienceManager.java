package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.WorkExperienceService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.WorkExperience;
import omerozturk.hrms.entities.concretes.dtos.WorkExperienceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    @Override
    public Result add(List<WorkExperienceDto> workExperience) {
        return null;
    }

    @Override
    public DataResult<List<WorkExperience>> getByBusinessDate(int employeeId) {
        return null;
    }
}
