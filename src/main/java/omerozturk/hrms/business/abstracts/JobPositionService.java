package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.JobPosition;

import java.util.List;
import java.util.Optional;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    DataResult<JobPosition> getById(int jobPositionId);
}
