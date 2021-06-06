package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.EmployeeImageService;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.EmployeeImage;
import omerozturk.hrms.entities.dtos.EmployeeImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/employeeimages")
public class EmployeeImagesController {
    private EmployeeImageService employeeImageService;

    @Autowired
    public EmployeeImagesController(EmployeeImageService employeeImageService) {
        this.employeeImageService = employeeImageService;
    }

    @PostMapping("/addToUrlImage")
    public ResponseEntity addToUrlImage(@RequestBody EmployeeImageDto employeeImageDto) {
        var result = employeeImageService.addToUrlImage(employeeImageDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody MultipartFile file, @RequestParam int employeeId){
        var result =  employeeImageService.addPhoto(employeeId,file);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        var result = employeeImageService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/getAllByEmployeeId")
    public ResponseEntity getAllByEmployeeId(int employeeId){
        var result = employeeImageService.getAllByEmployeeId(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
