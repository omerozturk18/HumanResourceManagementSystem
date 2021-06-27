package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceDao  extends JpaRepository<WorkExperience,Integer> {
    @Query("Select w from Resume r join r.workExperiences w where r.employee.id=:employeeId order by w.departureDate desc")
    List<WorkExperience> getByBusinessDate(int employeeId);

    List<WorkExperience> getAllByResumeIdOrderByDateOfStartDesc(int resumeId);
    WorkExperience getAllById(int id);
}
