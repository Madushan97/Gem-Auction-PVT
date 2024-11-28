package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.database.user.repository.UserRepository;
import com.madushan.Web.Auction.util.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUserName(username);
        if (Objects.isNull(user)) {
            System.out.println("User not registered");
            throw new UsernameNotFoundException("User not found");
        } else {
            return new CustomUserDetails(user);
        }
    }
}
