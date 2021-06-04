package omerozturk.hrms.api.controllers;


import omerozturk.hrms.business.abstracts.SchoolService;
import omerozturk.hrms.entities.concretes.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<SchoolDto> schools) {
        var result = schoolService.add(schools);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllByJobSeekerOrderByDateOfGraduation")
    public ResponseEntity getAllByEmployeeOrderByDateOfGraduation(int employeeId){
        var result = schoolService.getAllByEmployeeOrderByDateOfGraduation(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}