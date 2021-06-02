package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume,Integer> {
}
