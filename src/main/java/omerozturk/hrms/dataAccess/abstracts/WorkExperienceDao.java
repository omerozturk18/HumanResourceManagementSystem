package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao  extends JpaRepository<WorkExperience,Integer> {
}
