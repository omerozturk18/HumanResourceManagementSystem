package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    DataResult<List<User>> getAll();
    Result delete(User user);
    DataResult<User> getById(int userId);
}
