package pl.io_proj.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.io_proj.model.DBUser;
import pl.io_proj.repository.DBUserRepository;

@Component
public class AuthenticatedUserFacade {
    private DBUserRepository userRepository;

    @Autowired
    public void setRepository(DBUserRepository repository) {
        this.userRepository = repository;
    }
    public DBUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof DBUser)) {
            throw new EntityNotFoundException("Authorized user not found");
        }
        return (DBUser) principal;
    }
}
