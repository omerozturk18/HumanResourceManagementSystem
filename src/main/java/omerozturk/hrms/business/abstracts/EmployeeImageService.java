package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeImageService {
    Result add(EmployeeImage employeeImage);
    Result addPhoto(EmployeeImage employeeImage, MultipartFile multipartFile);
    DataResult<List<EmployeeImage>> getAll();
    DataResult<List<EmployeeImage>> getAllByEmployeeId(int employeeId);
}
