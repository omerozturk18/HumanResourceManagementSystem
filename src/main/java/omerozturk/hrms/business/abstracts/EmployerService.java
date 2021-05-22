package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employer;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    Result delete(Employer employer);
    DataResult<Optional<Employer>> getById(int employerId);
}
