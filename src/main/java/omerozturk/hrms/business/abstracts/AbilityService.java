package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.dtos.AbilityDto;

import java.util.List;

public interface AbilityService {
    Result add(List<AbilityDto> abilityDtos);
    Result update(List<AbilityDto> abilityDtos);
    DataResult<List<Ability>> getAllByResumeEmployeeId(int resumeId);
}
