package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.AbilityService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.AbilityDao;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.concretes.Resume;
import omerozturk.hrms.entities.concretes.dtos.AbilityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }
    @Override
    public Result add(List<AbilityDto> abilityDtos) {
        List<Ability> abilities = new ArrayList<Ability>();
        for (AbilityDto abilityDto : abilityDtos){
            var resume = new Resume();
            var ability = new Ability();
            ability.setId(abilityDto.getId());
            ability.setAbilityName(abilityDto.getAbilityName());
            ability.setTechnologyName(abilityDto.getTechnologyName());
            resume.setId(abilityDto.getResumeId());
            ability.setResume(resume);
            abilities.add(ability);
        }
        this.abilityDao.saveAll(abilities);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAll(int employeeId) {
        return new SuccessDataResult<>(this.abilityDao.getAll(employeeId));
    }
}
