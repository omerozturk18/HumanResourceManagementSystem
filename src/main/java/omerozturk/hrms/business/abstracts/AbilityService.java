package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Ability;

import java.util.List;

public interface AbilityService {
    Result add(List<Ability> abilities);
    DataResult<List<Ability>> getAllByResumeId(int resumeId);
}
