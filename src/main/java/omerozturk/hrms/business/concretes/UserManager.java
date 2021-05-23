package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.UserService;
import omerozturk.hrms.core.utilities.result.*;
import omerozturk.hrms.dataAccess.abstracts.UserDao;
import omerozturk.hrms.entities.concretes.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(userDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result delete(User user) {
        userDao.delete(user);
        return new SuccessResult("Kullanıcı Silindi");
    }

    @Override
    public DataResult<Optional<User>> getById(int userId) {
        return new SuccessDataResult<Optional<User>>(userDao.findById(userId),"Veri Listelendi");
    }
}
