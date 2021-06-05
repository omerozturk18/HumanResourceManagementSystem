package omerozturk.hrms.business.concretes;

import omerozturk.hrms.business.abstracts.JobPostingService;
import omerozturk.hrms.core.utilities.result.*;

import omerozturk.hrms.dataAccess.abstracts.JobPostingDao;
import omerozturk.hrms.entities.concretes.JobPosting;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper) {
		this.jobPostingDao = jobPostingDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		jobPosting.setStatus(true);
		jobPosting.setReleaseDate(new Date());
		//JobPosting jobPosting = modelMapper.map(jobPostingDto,JobPosting.class);
		jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result changeJobPostingStatus(int jobPostingId) {
		var jobPosting = getByJobPostingId(jobPostingId);
		if (!jobPosting.isSuccess()) {
			return new ErrorResult(jobPosting.getMessage());
		}
		jobPosting.getData().setStatus(!jobPosting.getData().isStatus());
		jobPostingDao.save(jobPosting.getData());
		return new SuccessResult("İlan durumu değiştirildi");
	}

	@Override
	public DataResult<JobPosting> getByJobPostingId(int jobPostingId) {
		var result = jobPostingDao.findById(jobPostingId).get();
		if (result == null) {
			return new ErrorDataResult<JobPosting>("Böyle bir iş ilanı bulunamadı");
		}
		return new SuccessDataResult<JobPosting>(result);
	}

	@Override
	public DataResult<List<JobPosting>> getByActiveJobPostings() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByStatus(true));
	}

	@Override
	public DataResult<List<JobPosting>> getByReleaseDateJobPosting(int value) {
		Sort sort;
		if (value == 0) {
			sort = Sort.by(Sort.Direction.DESC, "releaseDate");
		} else {
			sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		}
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByStatus(true, sort));
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployerJobPosting(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByStatusAndEmployerId(true, employerId));
	}

}