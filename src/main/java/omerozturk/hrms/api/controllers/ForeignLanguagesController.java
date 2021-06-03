package omerozturk.hrms.api.controllers;

import omerozturk.hrms.business.abstracts.ForeignLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService  foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }
}
