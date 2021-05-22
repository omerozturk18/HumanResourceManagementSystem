package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.EmployerService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return employerService.add(employer);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer){
        return employerService.delete(employer);
    }

    @GetMapping("/getbyid")
    public DataResult<Optional<Employer>> getById(int employeeId){
        return employerService.getById(employeeId);
    }
}
