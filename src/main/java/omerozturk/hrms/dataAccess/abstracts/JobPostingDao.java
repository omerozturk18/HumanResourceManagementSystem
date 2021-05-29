package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingDao extends JpaRepository<JobPosition,Integer> {
    
	List<JobPosting> getByIsActive(boolean isActive);

	List<JobPosting> getByIsActive(boolean isActive, Sort sort);

	List<JobPosting> getByIsActiveAndEmployerId(boolean isActive, int id);
}
