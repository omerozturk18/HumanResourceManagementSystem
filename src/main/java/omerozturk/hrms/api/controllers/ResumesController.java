package omerozturk.hrms.api.controllers;


import omerozturk.hrms.business.abstracts.ResumeService;
import omerozturk.hrms.entities.dtos.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result = resumeService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByEmployeeForResume")
    public ResponseEntity getByEmployeeForResume(int employeeId){
        var result = resumeService.getByEmployeeForResume(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}