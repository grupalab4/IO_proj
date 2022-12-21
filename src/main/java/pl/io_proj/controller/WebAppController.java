package pl.io_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.io_proj.service.DBUserService;

@RestController
public class WebAppController {

    private DBUserService service;

    @Autowired
    public void setService(DBUserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.toString();
    }
}
