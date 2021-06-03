package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.SchoolService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.School;
import omerozturk.hrms.entities.concretes.dtos.SchoolDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    @Override
    public Result add(List<SchoolDto> school) {
        return null;
    }

    @Override
    public DataResult<List<School>> getAllByEmployeeOrderByDateOfGraduation(int employeeId) {
        return null;
    }
}
