package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Resume;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResumeDao extends JpaRepository<Resume,Integer> {
   Resume getResumeByEmployeeId(int employeeId);
   Resume getByEmployeeId(int employeeId, Sort sort);
   Resume getById(int resumeId);
}
