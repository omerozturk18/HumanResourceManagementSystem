package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityDao extends JpaRepository<Ability,Integer> {
}
