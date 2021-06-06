package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.JobPostingService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.JobPosting;
import omerozturk.hrms.entities.dtos.JobPostingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPosting")
@CrossOrigin
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("add")
    public ResponseEntity add(@RequestBody JobPostingDto jobPostingDto) {
        var result= jobPostingService.add(jobPostingDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("changeStatus")
    public ResponseEntity changeStatus(@RequestParam int jobPostingId) {
        var result= jobPostingService.changeJobPostingStatus(jobPostingId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("getByActive")
    public ResponseEntity getByActive() {
        var result= jobPostingService.getByActiveJobPostings();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("getByReleaseDate")
    public ResponseEntity getByReleaseDate(@RequestParam int value) {
        var result= jobPostingService.getByReleaseDateJobPosting(value);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("getByEmployer")
    public ResponseEntity getByEmployer(@RequestParam int employerId) {
        var result= jobPostingService.getByEmployerJobPosting(employerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
