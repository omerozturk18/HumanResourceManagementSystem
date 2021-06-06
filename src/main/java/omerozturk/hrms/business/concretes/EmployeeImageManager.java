package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.EmployeeImageService;
import omerozturk.hrms.core.adapters.ImageService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.EmployeeImageDao;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import omerozturk.hrms.entities.dtos.EmployeeImageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeImageManager implements EmployeeImageService {
    private EmployeeImageDao employeeImageDao;
    private ModelMapper modelMapper;
    private ImageService imageService;

    @Autowired
    public EmployeeImageManager(EmployeeImageDao employeeImageDao,ModelMapper modelMapper,ImageService imageService) {
        this.employeeImageDao = employeeImageDao;
        this.modelMapper = modelMapper;
        this.imageService=imageService;
    }

    @Override
    public Result addToUrlImage(EmployeeImageDto employeeImageDto) {
        EmployeeImage employeeImage=modelMapper.map(employeeImageDto,EmployeeImage.class);
        employeeImageDao.save(employeeImage);
        return new SuccessResult();
    }

    @Override
    public Result addPhoto(int employeeId, MultipartFile multipartFile) {
        EmployeeImage employeeImage = new EmployeeImage();
        Employee employee = new Employee();
        employee.setId(employeeId);
        employeeImage.setEmployee(employee);
        Map<String,String> result = (Map<String,String>)imageService.save(multipartFile).getData();
        String url = result.get("url");
        employeeImage.setUrl(url);
        employeeImage.setUploadedAt(LocalDate.now());
        employeeImageDao.save(employeeImage);
        return new SuccessResult();
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
