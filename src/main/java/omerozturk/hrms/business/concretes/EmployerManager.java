package omerozturk.hrms.business.concretes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import omerozturk.hrms.business.abstracts.EmployerService;
import omerozturk.hrms.core.utilities.result.*;
import omerozturk.hrms.dataAccess.abstracts.EmployerDao;
import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.BinaryOperator;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployerManager(EmployerDao employerDao,ObjectMapper objectMapper) {
        this.employerDao = employerDao;
        this.objectMapper=objectMapper;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult(" Eklendi");
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult(" Silindi");
    }

    @Override
    public DataResult<Employer> getById(int employerId) {
        return new SuccessDataResult<Employer>(employerDao.getById(employerId),"Veri Listelendi");
    }

    @Override
    public Result systemUpdate(int employerId) throws IOException {
        List<Employer> employers= objectMapper.readValue(new File("target/employer.json"),new TypeReference<List<Employer>>(){});
        for (Employer employer : employers) {
            if(employer.getId()==employerId){
                employerDao.save(employer);
                employers.remove(employer);
                objectMapper.writeValue(new File("target/employer.json"), employers);
                return new SuccessResult(" Güncellendi");
            }
        }
        return  new ErrorResult("Firma Bulunamadı");
    }
    @Override
    public Result update(Employer employer) throws IOException {
        List<Employer> employers= objectMapper.readValue(new File("target/employer.json"),new TypeReference<List<Employer>>(){});
        for (Employer employerJson : employers) {
            if(employerJson.getId()==employer.getId()){
                employers.remove(employerJson);
                break;
            }
        }
        employers.add(employer);
        objectMapper.writeValue(new File("target/employer.json"), employers);

        Employer newEmployer=employerDao.getById(employer.getId());
        newEmployer.setUpdateVerifiedBySystem(false);
        employerDao.save(newEmployer);
        return new SuccessResult(" Güncellendi, Onay Bekliyor");
    }
}
