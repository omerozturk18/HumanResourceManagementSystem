package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.SystemUserService;
import omerozturk.hrms.dataAccess.abstracts.SystemUserDao;

import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserManager implements SystemUserService {
    private SystemUserDao systemUserDao;

    @Autowired
    public SystemUserManager(SystemUserDao systemUserDao) {
        this.systemUserDao = systemUserDao;
    }

    @Override
    public List<SystemUser> getAll() {
        return  systemUserDao.findAll();
    }
}
