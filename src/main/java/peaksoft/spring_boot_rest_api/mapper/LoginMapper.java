package peaksoft.spring_boot_rest_api.mapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.models.Role;
import peaksoft.spring_boot_rest_api.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LoginMapper {

    public LoginResponse loginView(String token, String message, User user){

        var loginResponse = new LoginResponse();

        if (user != null){

            setAuthority(loginResponse,user.getRoles());

        }

        loginResponse.setJwtToken(token);

        loginResponse.setMessages(message);

        return loginResponse;
    }

    private void setAuthority(LoginResponse loginResponse, List<Role> roles) {

        Set<String> authorities = new HashSet<>();

        for (Role role : roles){

            authorities.add(role.getRoleName());

        }

        loginResponse.setAuthorities(authorities);

    }
}
