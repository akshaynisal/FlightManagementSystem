package com.cts.com.cts.security.service;

import com.cts.com.cts.security.service.dto.UserRegistrationDto;
import com.cts.entities.User;
import com.cts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setUserName(registration.getUserName());
        user.setPassword(registration.getPassword());
        user.setGender(registration.getGender());
        user.setMobile(registration.getMobile());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
