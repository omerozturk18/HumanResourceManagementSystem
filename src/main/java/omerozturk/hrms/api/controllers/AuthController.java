package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.AuthService;

import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.Employee;
import omerozturk.hrms.entities.concretes.Employer;
import omerozturk.hrms.entities.concretes.User;
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
    public Result registerForEmployee(@RequestBody User user, Employee employee){
        return authService.registerForEmployee(user,employee);
    }

    @PostMapping("/registerForEmployer")
    public Result registerForEmployer(@RequestBody User user, Employer employer){
        return authService.registerForEmployer(user,employer);
    }

}
