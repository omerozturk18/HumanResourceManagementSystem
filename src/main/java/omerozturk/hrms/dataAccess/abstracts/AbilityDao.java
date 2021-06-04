package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability,Integer> {
    List<Ability> getAllByResumeId(int resumeId);
}
