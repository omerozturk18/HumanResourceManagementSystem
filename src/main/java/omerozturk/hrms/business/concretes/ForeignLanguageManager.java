package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.ForeignLanguageService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.ForeignLanguage;
import omerozturk.hrms.entities.concretes.dtos.ForeignLanguageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    @Override
    public Result add(List<ForeignLanguageDto> foreignLanguage) {
        return null;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll(int employeeId) {
        return null;
    }
}
