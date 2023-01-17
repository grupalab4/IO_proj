package pl.io_proj.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.io_proj.model.DBUser;


@Component
public class AuthenticatedUserFacade {
    public DBUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof DBUser)) {
            throw new EntityNotFoundException("Authorized user not found");
        }
        return (DBUser) principal;
    }
}
