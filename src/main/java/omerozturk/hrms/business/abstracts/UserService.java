package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
