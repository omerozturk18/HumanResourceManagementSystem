package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user);
    Result delete(User user);
    DataResult<Optional<User>> getById(int userId);
}
