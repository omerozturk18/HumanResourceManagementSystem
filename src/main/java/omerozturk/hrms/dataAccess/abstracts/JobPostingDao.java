package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.JobPosting;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
   List<JobPosting> getByStatus(boolean status);

    List<JobPosting> getByStatus(boolean status, Sort sort);

    List<JobPosting> getByStatusAndEmployerId(boolean status, int id);
}
