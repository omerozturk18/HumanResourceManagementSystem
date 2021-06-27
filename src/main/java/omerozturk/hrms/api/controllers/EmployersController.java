package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.EmployerService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result =  employerService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Employer employer){
        var result =  employerService.add(employer);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody Employer employer){
        var result =  employerService.delete(employer);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getbyid")
    public ResponseEntity getById(int employerId){
        var result =  employerService.getById(employerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PostMapping("/systemUpdate")
    public ResponseEntity systemUpdate(@RequestBody int employerId) throws IOException {
        var result =  employerService.systemUpdate(employerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Employer employer) throws IOException {
        var result =  employerService.update(employer);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
