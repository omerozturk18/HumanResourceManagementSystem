package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.concretes.FavoriteJobPosting;
import omerozturk.hrms.entities.dtos.AbilityDto;

import java.util.List;

public interface FavoriteJobPostingService {
    Result add(FavoriteJobPosting favoriteJobPostings);
    DataResult<List<FavoriteJobPosting>> getAllByEmployeeId(int employeeId);
}
