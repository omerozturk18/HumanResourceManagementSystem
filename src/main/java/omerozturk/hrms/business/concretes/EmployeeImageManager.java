package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployeeImageService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmployeeImageManager implements EmployeeImageService {
    @Override
    public Result add(EmployeeImage employeeImage) {
        return null;
    }

    @Override
    public Result addPhoto(EmployeeImage employeeImage, MultipartFile multipartFile) {
        return null;
    }

    @Override
    public DataResult<List<EmployeeImage>> getAll() {
        return null;
    }

    @Override
    public DataResult<List<EmployeeImage>> getAllByEmployeeId(int employeeId) {
        return null;
    }
}
