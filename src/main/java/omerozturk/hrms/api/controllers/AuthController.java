package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.AuthService;

import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.dtos.EmployeeForRegisterDto;
import omerozturk.hrms.entities.dtos.EmployerForRegisterDto;
import omerozturk.hrms.entities.dtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/registerForEmployee")
    public ResponseEntity registerForEmployee(@RequestBody EmployeeForRegisterDto employeeForRegisterDto){
        var result= authService.registerForEmployee(employeeForRegisterDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/registerForEmployer")
    public ResponseEntity registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto){
        var result= authService.registerForEmployer(employerForRegisterDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/login")
    public ResponseEntity registerForEmployee( UserForLoginDto userForLoginDto){
        var result= authService.login(userForLoginDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
