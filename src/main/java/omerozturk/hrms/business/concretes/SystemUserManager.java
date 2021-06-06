package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.SystemUserService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.SystemUserDao;

import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemUserManager implements SystemUserService {
    private SystemUserDao systemUserDao;

    @Autowired
    public SystemUserManager(SystemUserDao systemUserDao) {
        this.systemUserDao = systemUserDao;
    }


    @Override
    public DataResult<List<SystemUser>> getAll() {
        return new SuccessDataResult<List<SystemUser>>(systemUserDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(SystemUser systemUser) {
        systemUserDao.save(systemUser);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public Result delete(SystemUser systemUser) {
        systemUserDao.delete(systemUser);
        return new SuccessResult("Kullanıcı Silindi");
    }

    @Override
    public DataResult<SystemUser> getById(int systemUserId) {
        return new SuccessDataResult<SystemUser>(systemUserDao.getById(systemUserId),"Veri Listelendi");
    }
}
