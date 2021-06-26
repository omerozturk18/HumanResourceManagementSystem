package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    Result delete(Employer employer);
    DataResult<Employer>  getById(int employerId);
    Result systemUpdate(int employerId) throws IOException;
    Result update(Employer employer) throws IOException;
}
