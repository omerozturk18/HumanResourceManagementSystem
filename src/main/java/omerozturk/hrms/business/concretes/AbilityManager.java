package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.AbilityService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.AbilityDao;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.dtos.AbilityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;
    private ModelMapper modelMapper;

    @Autowired
    public AbilityManager(AbilityDao abilityDao,ModelMapper modelMapper) {
        this.abilityDao = abilityDao;
        this.modelMapper=modelMapper;
    }
    @Override
    public Result add(List<AbilityDto> abilityDtos) {
        List<Ability> abilities  = new ArrayList<Ability>();
        for (AbilityDto abilityDto : abilityDtos){
            abilities.add(modelMapper.map(abilityDto,Ability.class));
        }
        this.abilityDao.saveAll(abilities);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAllByResumeEmployeeId(int employeeId) {
        return new SuccessDataResult<>(this.abilityDao.getAllByResumeEmployeeId(employeeId));
    }
}
