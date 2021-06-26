package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.*;
import omerozturk.hrms.entities.dtos.*;

import java.util.List;

public interface ResumeService {
    Result add(ResumeDto resumeDto);
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getByEmployeeForResume(int employeeId);
    Result update(ResumeDto resumeDto);
}
