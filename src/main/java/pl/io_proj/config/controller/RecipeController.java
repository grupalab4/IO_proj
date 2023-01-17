package pl.io_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.io_proj.service.RecipeService;

@RestController
@RequestMapping(path = "api/recipes")
public class RecipeController {

    private RecipeService service;

    @Autowired
    public void setService(RecipeService service) {
        this.service = service;
    }
}
