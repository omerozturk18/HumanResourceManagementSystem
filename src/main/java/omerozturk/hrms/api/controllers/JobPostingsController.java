package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.JobPostingService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.JobPosting;
import omerozturk.hrms.entities.concretes.dtos.JobPostingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobPosting jobPostingDto) {
        return jobPostingService.add(jobPostingDto);
    }

    @PostMapping("changeStatus")
    public Result changeStatus(@RequestParam int jobPostingId) {
        return jobPostingService.changeJobPostingStatus(jobPostingId);
    }

    @GetMapping("getByActive")
    public Result getByActive() {
        return jobPostingService.getByActiveJobPostings();
    }

    @GetMapping("getByReleaseDate")
    public DataResult<List<JobPosting>> getByReleaseDate(@RequestParam int value) {
        return jobPostingService.getByReleaseDateJobPosting(value);
    }

    @GetMapping("getByEmployer")
    public DataResult<List<JobPosting>> getByEmployer(@RequestParam int employerId) {
        return jobPostingService.getByEmployerJobPosting(employerId);
    }
}
