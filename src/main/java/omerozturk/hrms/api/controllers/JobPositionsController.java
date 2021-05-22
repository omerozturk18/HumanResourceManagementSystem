package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.JobPositionService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return jobPositionService.add(jobPosition);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPosition jobPosition){
        return jobPositionService.delete(jobPosition);
    }

    @GetMapping("/getbyid")
    public DataResult<Optional<JobPosition>> getById(int jobPositionId){
        return jobPositionService.getById(jobPositionId);
    }
}
