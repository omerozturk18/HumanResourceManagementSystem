package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.CityService;
import omerozturk.hrms.core.utilities.result.DataResult;
import omerozturk.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }

}
