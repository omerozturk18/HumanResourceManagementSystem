package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao  extends JpaRepository<School,Integer> {
}
