package omerozturk.hrms.dataAccess.abstracts;

import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    Employer getById(int employerId);

    @Modifying
    @Transactional
    @Query("UPDATE Employer  SET companyName=:companyName,phoneNumber=:phoneNumber,webSite=:webSite,verifiedBySystem=:verifiedBySystem,updateVerifiedBySystem=:updateVerifiedBySystem where id=:id")
     void update(
             @Param("id") int id,
             @Param("companyName") String companyName,
             @Param("phoneNumber") String phoneNumber,
             @Param("webSite") String webSite,
             @Param("verifiedBySystem") boolean verifiedBySystem,
             @Param("updateVerifiedBySystem") boolean updateVerifiedBySystem
    );

}
