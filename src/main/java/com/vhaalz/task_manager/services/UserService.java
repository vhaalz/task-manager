package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void register(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }

    public String verify(User user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                    )
                );
        if (authentication.isAuthenticated()){
            return "Login Successfully";
        }
        return "Failed";
    }
}
