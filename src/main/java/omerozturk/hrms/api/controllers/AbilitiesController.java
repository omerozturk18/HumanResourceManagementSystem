package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.AbilityService;
import omerozturk.hrms.entities.concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private AbilityService abilityService;

    @Autowired
    public AbilitiesController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/getAllByResumeId")
    public ResponseEntity getAllByResumeId(int resumeId){
        var result = abilityService.getAllByResumeId(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<Ability> abilities) {
        var result = abilityService.add(abilities);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
