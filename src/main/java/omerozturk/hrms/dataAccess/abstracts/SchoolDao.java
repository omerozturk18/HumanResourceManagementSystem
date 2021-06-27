package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolDao  extends JpaRepository<School,Integer> {
    @Query("Select s from Resume r join r.schools s where r.employee.id=:employeeId order by s.dateOfGraduation desc")
    List<School> findByOrderByDateOfGraduationDesc(int employeeId);
    List<School> getAllByResumeIdOrderByDateOfGraduationDesc(int resumeId);
}
