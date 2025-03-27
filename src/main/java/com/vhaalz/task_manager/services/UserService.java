package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.domain.Mapper;
import com.vhaalz.task_manager.domain.UserRequest;
import com.vhaalz.task_manager.jwt.JWTService;
import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepo repo;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final Mapper mapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public Long register(@Valid UserRequest request) {

        var user = mapper.toUser(request);
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user).getId();
    }

    public String verify(User user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                    )
                );
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "Failed";
    }


}
