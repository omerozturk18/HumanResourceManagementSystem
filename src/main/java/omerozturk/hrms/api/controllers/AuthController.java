package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.AuthService;

import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.dtos.EmployeeForRegisterDto;
import omerozturk.hrms.entities.concretes.dtos.EmployerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/registerForEmployee")
    public Result registerForEmployee(@RequestBody EmployeeForRegisterDto employeeForRegisterDto){
        return authService.registerForEmployee(employeeForRegisterDto);
    }

    @PostMapping("/registerForEmployer")
    public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto){
        return authService.registerForEmployer(employerForRegisterDto);
    }

}
