package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.concretes.dtos.AbilityDto;

import java.util.List;

public interface AbilityService {
    Result add(List<AbilityDto> abilityDtos);
    DataResult<List<Ability>> getAll(int employeeId);
}
