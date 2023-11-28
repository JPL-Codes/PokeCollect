package org.pokecollect.service;

import org.pokecollect.dao.UserRepository;
import org.pokecollect.dto.SecurityUser;
import org.pokecollect.dto.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService extends User implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.get();
        SecurityUser securityUser = new SecurityUser(user, user.getId());
        return securityUser;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String roles) {
        return Arrays.stream(
                        roles
                                .split(","))
                .map(role -> new SimpleGrantedAuthority(role))
                .toList();
    }
}
