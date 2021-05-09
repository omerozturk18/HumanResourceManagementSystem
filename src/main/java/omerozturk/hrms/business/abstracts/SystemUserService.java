package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.entities.concretes.SystemUser;

import java.util.List;

public interface SystemUserService {
    List<SystemUser> getAll();
}
