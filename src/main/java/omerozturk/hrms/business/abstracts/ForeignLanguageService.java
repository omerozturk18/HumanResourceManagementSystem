package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.ForeignLanguage;
import omerozturk.hrms.entities.concretes.dtos.ForeignLanguageDto;

import java.util.List;

public interface ForeignLanguageService {
    Result add(List<ForeignLanguageDto> foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll(int employeeId);
}
