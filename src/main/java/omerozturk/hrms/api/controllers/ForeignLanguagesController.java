package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.ForeignLanguageService;
import omerozturk.hrms.entities.dtos.ForeignLanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/foreignlanguages")
@CrossOrigin
public class ForeignLanguagesController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService  foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<ForeignLanguageDto> foreignLanguageDtos) {
        var result = foreignLanguageService.add(foreignLanguageDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        var result = foreignLanguageService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/getAllByEmployeeId")
    public ResponseEntity getAllByEmployeeId(int employeeId){
        var result = foreignLanguageService.getAllByEmployeeId(employeeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
