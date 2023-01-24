package pl.io_proj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io_proj.dto.UserDTO;
import pl.io_proj.model.DBUser;
import pl.io_proj.model.Product;
import pl.io_proj.service.DBUserService;

@RestController
@RequestMapping(path = "api/users")
public class DBUserController {

    private DBUserService service;

    @Autowired
    public void setService(DBUserService service) {
        this.service = service;
    }

    @GetMapping(path = "/register", produces = "application/json")
    public String register(String username, String password, String firstName, String surname, Integer age,
            Integer height, Integer weight) throws JsonProcessingException {
        return service.register(username, password, firstName, surname, age, height, weight);
    }

    @GetMapping("/about")
    public ResponseEntity<?> getCurrentDBUser() {

        try {
            DBUser user = service.getCurrentDBUser();
            UserDTO userDto = new UserDTO(user);

            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
