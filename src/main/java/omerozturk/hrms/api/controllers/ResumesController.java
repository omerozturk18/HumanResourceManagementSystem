package omerozturk.hrms.api.controllers;


import omerozturk.hrms.business.abstracts.ResumeService;
import omerozturk.hrms.entities.concretes.Ability;
import omerozturk.hrms.entities.concretes.ForeignLanguage;
import omerozturk.hrms.entities.concretes.School;
import omerozturk.hrms.entities.concretes.WorkExperience;
import omerozturk.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ResumeDto resumeDto) {
        var result = resumeService.add(resumeDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ResumeDto resumeDto) {
        var result = resumeService.update(resumeDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result = resumeService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getById")
    public ResponseEntity getById(int resumeId){
        var result = resumeService.getById(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/getByEmployeeIdAndDate")
    public ResponseEntity getByEmployeeIdAndDate(int employeeId){
        var result = resumeService.getByEmployeeIdAndDate(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}