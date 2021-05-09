package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
}
