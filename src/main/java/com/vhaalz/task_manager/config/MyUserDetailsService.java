package com.vhaalz.task_manager.config;

import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("cannot find user with the email: "+email);
        }
        return new UserPrincipal(user);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // get the username from the Authentication object
        return repo.findByEmail(email); // Use the username to fetch the User entity from DB
    }

}
