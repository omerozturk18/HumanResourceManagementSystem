package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.UserService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.core.utilities.result.Result;
import omerozturk.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
       return userService.getAll();
    }


    @PostMapping("/delete")
    public Result delete(@RequestBody User user){
        return userService.delete(user);
    }

    @GetMapping("/getbyid")
    public DataResult<Optional<User>> getById(int userId){
        return userService.getById(userId);
    }
}
