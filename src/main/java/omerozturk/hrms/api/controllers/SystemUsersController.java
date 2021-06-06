package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.SystemUserService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {
    private SystemUserService systemUserService;

    @Autowired
    public SystemUsersController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result= systemUserService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody SystemUser systemUser){
        var result= systemUserService.add(systemUser);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody SystemUser systemUser){
        var result= systemUserService.delete(systemUser);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getbyid")
    public ResponseEntity getById(int systemUserId){
        var result= systemUserService.getById(systemUserId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
