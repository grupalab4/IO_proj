package pl.io_proj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.io_proj.model.DBUser;
import pl.io_proj.repository.DBUserRepository;
import pl.io_proj.responses.RegisterResponse;

@Service
public class DBUserService {
    private DBUserRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setRepository(DBUserRepository repository) {
        this.repository = repository;
    }

    public DBUser addDBUser(DBUser user) {
        DBUser newUser = new DBUser();

        newUser.setFirstName(user.getFirstName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setHeight(user.getHeight());
        newUser.setWeight(user.getWeight());
        newUser.setAge(user.getAge());

        return repository.save(newUser);
    }

    public boolean existsDBUserByUsername(String username) {
        return repository.existsDBUserByUsername(username);
    }

    public DBUser getDBUserByUsername(String username) {
        return repository.getDBUserByUsername(username);
    }

    public String register(String username, String password, String firstName, String surname, Integer age, Integer height, Integer weight) throws JsonProcessingException {
        if (username == null || password == null || firstName == null || surname == null || age == null || height == null || weight == null)
            return RegisterResponse.NotEnoughParameters.json();

        if (existsDBUserByUsername(username))
            return RegisterResponse.UserAlreadyExists.json();

        addDBUser(new DBUser(username, password, firstName, surname, weight, height, age));
        return RegisterResponse.Ok.json();
    }
}
