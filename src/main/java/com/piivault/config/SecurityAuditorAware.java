package com.piivault.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Retrieve the currently authenticated user from Spring Security
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.ofNullable(user != null ? user.getUsername() : "system");
    }
}
