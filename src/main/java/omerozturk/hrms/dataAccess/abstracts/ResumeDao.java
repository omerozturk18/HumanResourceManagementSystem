package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Resume;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResumeDao extends JpaRepository<Resume,Integer> {
   Resume getResumeByEmployeeId(int employeeId);
   Resume getByEmployeeId(int employeeId, Sort sort);
   List<Resume> getAllByEmployeeIdOrderByDateOfResumeDesc(int employeeId);
   Resume getById(int resumeId);
}
