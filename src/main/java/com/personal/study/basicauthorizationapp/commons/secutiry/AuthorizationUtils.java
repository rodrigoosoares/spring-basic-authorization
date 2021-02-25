package com.personal.study.basicauthorizationapp.commons.secutiry;

import com.personal.study.basicauthorizationapp.commons.secutiry.entities.SecurityRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorizationUtils {

    public List<SecurityRoles> getUserRoles() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(this::getSecurityRoles)
                .collect(Collectors.toList());
    }


    private SecurityRoles getSecurityRoles(final String role) {
        final String formattedRole = role.replace("ROLE_", "");
        return SecurityRoles.valueOf(formattedRole);
    }

    public boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(role -> SecurityRoles.ADMIN.equals(getSecurityRoles(role)));
    }

}
