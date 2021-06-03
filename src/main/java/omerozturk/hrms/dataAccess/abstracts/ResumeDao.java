package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.entities.concretes.Resume;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume,Integer> {
   Resume getByEmployeeId(int employeeId);
   Resume getByEmployeeId(int employeeId, Sort sort);
}
