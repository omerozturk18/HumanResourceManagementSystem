package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
}
