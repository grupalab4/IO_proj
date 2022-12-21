package pl.io_proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import pl.io_proj.service.DBUserService;

import java.util.ArrayList;

@Component
public class IOAuthenticationProvider implements AuthenticationProvider {

    private DBUserService service;

    @Autowired
    public void setService(DBUserService service) {
        this.service = service;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(!service.existsDBUserByUsername(authentication.getName())) throw new BadCredentialsException("User not found in DB!");
        if(!BCrypt.checkpw(authentication.getCredentials().toString(), service.findDBUserByUsername(authentication.getName()).getPassword())) throw new BadCredentialsException("Wrong password for user " + authentication.getCredentials());

        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
