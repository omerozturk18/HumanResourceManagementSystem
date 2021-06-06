package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.SystemUser;

import java.util.List;
import java.util.Optional;

public interface SystemUserService {
    DataResult<List<SystemUser>> getAll();
    Result add(SystemUser systemUser);
    Result delete(SystemUser systemUser);
    DataResult<SystemUser> getById(int systemUserId);
}
