package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.School;
import omerozturk.hrms.entities.concretes.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {
    Result add(List<SchoolDto> school);
    DataResult<List<School>> getAllByEmployeeOrderByDateOfGraduation(int employeeId);
}
