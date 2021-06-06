package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.SchoolService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.SchoolDao;
import omerozturk.hrms.entities.concretes.School;
import omerozturk.hrms.entities.dtos.SchoolDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;
    private ModelMapper modelMapper;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, ModelMapper modelMapper) {
        this.schoolDao = schoolDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(List<SchoolDto> schoolDtos) {
        List<School> schools = new ArrayList<School>();
        for (SchoolDto schoolDto : schoolDtos){
            schools.add(modelMapper.map(schoolDto,School.class));
        }
        schoolDao.saveAll(schools);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<School>> getAllByEmployeeOrderByDateOfGraduation(int employeeId) {
        return new SuccessDataResult<List<School>>(schoolDao.findByOrderByDateOfGraduationDesc(employeeId));
    }
}
