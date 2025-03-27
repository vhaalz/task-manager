package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.domain.LoginRequest;
import com.vhaalz.task_manager.domain.Mapper;
import com.vhaalz.task_manager.domain.RegisterRequest;
import com.vhaalz.task_manager.jwt.JWTService;
import com.vhaalz.task_manager.repos.UserRepo;
import lombok.AllArgsConstructor;
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


    public Long register(RegisterRequest request) {

        var user = mapper.toUser(request);
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user).getId();
    }

    public String verify(LoginRequest request) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.username(), request.password()
                    )
                );
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(request.username());
        }
        return "Failed";
    }

}
