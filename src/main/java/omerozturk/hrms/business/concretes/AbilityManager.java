package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.AbilityService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.AbilityDao;
import omerozturk.hrms.entities.concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }
    @Override
    public Result add(List<Ability> abilities) {
        this.abilityDao.saveAll(abilities);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<>(this.abilityDao.getAllByResumeId(resumeId));
    }
}
