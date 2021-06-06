package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.WorkExperience;
import omerozturk.hrms.entities.dtos.WorkExperienceDto;

import java.util.List;

public interface WorkExperienceService {
    Result add (List<WorkExperienceDto> workExperienceDtos);
    DataResult<List<WorkExperience>> getByBusinessDate(int employeeId);
}
