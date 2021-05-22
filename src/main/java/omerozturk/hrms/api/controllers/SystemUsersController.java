package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.SystemUserService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<SystemUser>> getAll(){
        return systemUserService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemUser systemUser){
        return systemUserService.add(systemUser);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody SystemUser systemUser){
        return systemUserService.delete(systemUser);
    }

    @GetMapping("/getbyid")
    public DataResult<Optional<SystemUser>> getById(int systemUserId){
        return systemUserService.getById(systemUserId);
    }
}
