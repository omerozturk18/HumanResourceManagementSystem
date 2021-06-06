package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.WorkExperienceService;
import omerozturk.hrms.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperiencesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<WorkExperienceDto> workExperienceDtos) {
        var result = workExperienceService.add(workExperienceDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllByBusinessDate")
    public ResponseEntity getAllByBusinessDate(int employeeId){
        var result = workExperienceService.getByBusinessDate(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
