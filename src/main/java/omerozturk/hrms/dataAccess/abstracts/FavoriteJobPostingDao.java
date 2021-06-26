package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobPostingDao extends JpaRepository<FavoriteJobPosting,Integer> {
    List<FavoriteJobPosting> getAllByEmployeeId(int employeeId);

}
