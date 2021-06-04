package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployeeImageService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.EmployeeImageDao;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmployeeImageManager implements EmployeeImageService {
    private EmployeeImageDao employeeImageDao;

    @Autowired
    public EmployeeImageManager(EmployeeImageDao employeeImageDao) {
        this.employeeImageDao = employeeImageDao;
    }

    @Override
    public Result add(EmployeeImage employeeImage) {
        employeeImageDao.save(employeeImage);
        return new SuccessResult();
    }

    @Override
    public Result addPhoto(EmployeeImage employeeImage, MultipartFile multipartFile) {
        return null;
    }

    @Override
    public DataResult<List<EmployeeImage>> getAll() {
        return new SuccessDataResult<List<EmployeeImage>>(employeeImageDao.findAll());
    }

    @Override
    public DataResult<List<EmployeeImage>> getAllByEmployeeId(int employeeId) {
        return new SuccessDataResult<List<EmployeeImage>>(employeeImageDao.getAllByEmployeeId(employeeId));
    }
}
