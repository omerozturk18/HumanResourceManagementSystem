package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import omerozturk.hrms.entities.dtos.EmployeeImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeImageService {
    Result addToUrlImage(EmployeeImageDto employeeImageDto);
    Result addPhoto(int employeeId, MultipartFile multipartFile);
    DataResult<List<EmployeeImage>> getAll();
    DataResult<List<EmployeeImage>> getAllByEmployeeId(int employeeId);
}
