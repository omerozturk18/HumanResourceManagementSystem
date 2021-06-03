package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.EmployeeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employeeimages")
public class EmployeeImagesController {
    private EmployeeImageService employeeImageService;

    @Autowired
    public EmployeeImagesController(EmployeeImageService employeeImageService) {
        this.employeeImageService = employeeImageService;
    }
}
