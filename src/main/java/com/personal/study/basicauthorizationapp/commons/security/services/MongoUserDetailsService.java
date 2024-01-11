package com.personal.study.basicauthorizationapp.commons.security.services;

import com.personal.study.basicauthorizationapp.entrypoints.gateways.entities.User;
import com.personal.study.basicauthorizationapp.entrypoints.gateways.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<User> userOpt = userMongoRepository.findByUsername(username);

        if(userOpt.isPresent()) {
            final User user = userOpt.get();
            final List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.name())));

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
