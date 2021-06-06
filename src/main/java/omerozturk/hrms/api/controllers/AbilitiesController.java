package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.AbilityService;
import omerozturk.hrms.entities.dtos.AbilityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
@CrossOrigin
public class AbilitiesController {

    private AbilityService abilityService;

    @Autowired
    public AbilitiesController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/getAllByResumeEmployeeId")
    public ResponseEntity getAllByResumeEmployeeId(int employeeId){
        var result = abilityService.getAllByResumeEmployeeId(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<AbilityDto> abilityDtos) {
        var result = abilityService.add(abilityDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
