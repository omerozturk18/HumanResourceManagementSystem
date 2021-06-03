package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Resume;
import omerozturk.hrms.entities.concretes.dtos.ResumeDto;

import java.util.List;

public interface ResumeService {
    Result add(ResumeDto resumeDto);
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getByEmployeeForResume(int employeeId);
    DataResult<Resume> getAllForInOrder(int employeeId);
}
