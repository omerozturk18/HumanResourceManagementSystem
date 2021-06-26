package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.School;
import omerozturk.hrms.entities.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {
    Result add(List<SchoolDto> schoolDtos);
    Result update(List<SchoolDto> schoolDtos);
    DataResult<List<School>> getAllByEmployeeOrderByDateOfGraduation(int employeeId);
}
