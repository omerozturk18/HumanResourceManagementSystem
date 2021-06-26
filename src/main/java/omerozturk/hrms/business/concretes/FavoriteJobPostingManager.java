package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.FavoriteJobPostingService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import omerozturk.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService {

    private FavoriteJobPostingDao favoriteJobPostingDao;

    @Autowired
    public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao) {
        this.favoriteJobPostingDao = favoriteJobPostingDao;
    }

    @Override
    public Result add(FavoriteJobPosting favoriteJobPosting) {
        favoriteJobPostingDao.save(favoriteJobPosting);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<FavoriteJobPosting>> getAllByEmployeeId(int employeeId) {
        return new SuccessDataResult<List<FavoriteJobPosting>>(this.favoriteJobPostingDao.getAllByEmployeeId(employeeId));
    }
}
