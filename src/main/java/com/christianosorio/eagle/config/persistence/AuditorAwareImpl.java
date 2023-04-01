package com.christianosorio.eagle.config.persistence;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    private static final String DEFAULT_AUDITOR_USER = "ADMIN";

    @Override
    public Optional<String> getCurrentAuditor() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return Optional.of(authentication.getName());
        }
        return Optional.of(DEFAULT_AUDITOR_USER);
    }
}
