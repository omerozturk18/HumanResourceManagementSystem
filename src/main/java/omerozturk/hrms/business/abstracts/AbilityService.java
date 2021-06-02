package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Ability;

import java.util.List;

public interface AbilityService {
    Result add(List<Ability> ability);
    DataResult<List<Ability>> getAll(int employeeId);
}
