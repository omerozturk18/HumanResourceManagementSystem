package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.ForeignLanguageService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.core.utilities.result.SuccessDataResult;
import omerozturk.hrms.core.utilities.result.SuccessResult;
import omerozturk.hrms.dataAccess.abstracts.ForeignLanguageDao;
import omerozturk.hrms.entities.concretes.ForeignLanguage;
import omerozturk.hrms.entities.dtos.ForeignLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    private ForeignLanguageDao foreignLanguageDao;
    private ModelMapper modelMapper;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, ModelMapper modelMapper) {
        this.foreignLanguageDao = foreignLanguageDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(List<ForeignLanguageDto> foreignLanguageDtos) {
        List<ForeignLanguage> foreignLanguages = new ArrayList<ForeignLanguage>();
        for (ForeignLanguageDto foreignLanguageDto : foreignLanguageDtos){
            foreignLanguages.add(modelMapper.map(foreignLanguageDto,ForeignLanguage.class));
        }
        foreignLanguageDao.saveAll(foreignLanguages);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguageDao.findAll());
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAllByEmployeeId(int employeeId) {
        return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguageDao.getAll(employeeId));
    }
}
