package omerozturk.hrms.business.abstracts;

import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.JobPosting;
import omerozturk.hrms.entities.concretes.dtos.JobPostingDto;

import java.util.List;
import java.util.Optional;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result changeJobPostingStatus(int jobPostingId);
	DataResult<JobPosting> getByJobPostingId(int jobPostingId);
	DataResult<List<JobPosting>> getByActiveJobPostings();
	DataResult<List<JobPosting>> getByReleaseDateJobPosting(int value);
	DataResult<List<JobPosting>> getByEmployerJobPosting(int employerId);
}
