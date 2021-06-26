package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.FavoriteJobPostingService;
import omerozturk.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/favorite")
@CrossOrigin
public class FavoriteJobPostingsController {

    private FavoriteJobPostingService favoriteJobPostingService;

    @Autowired
    public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService) {
        this.favoriteJobPostingService = favoriteJobPostingService;
    }

    @GetMapping("/getAllByEmployeeId")
    public ResponseEntity getAllByEmployeeId(int employeeId){
        var result = favoriteJobPostingService.getAllByEmployeeId(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody FavoriteJobPosting favoriteJobPosting) {
        var result = favoriteJobPostingService.add(favoriteJobPosting);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
