package pl.io_proj.service;

import jakarta.servlet.http.HttpServletRequest;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import pl.io_proj.model.DBUser;
import pl.io_proj.repository.DBUserRepository;


@Component
@RequiredArgsConstructor
public class AuthenticatedUserFacade {
    private final DBUserRepository repository;

    public DBUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.isAuthenticated()){
            throw new RuntimeException("User is not logged!");
        }

        return repository.getDBUserByUsername(authentication.getName());
    }
}
