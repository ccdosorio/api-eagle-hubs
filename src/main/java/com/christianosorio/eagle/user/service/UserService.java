package com.christianosorio.eagle.user.service;

import com.christianosorio.eagle.exception.impl.ResourceNotFoundException;
import com.christianosorio.eagle.model.user.User;
import com.christianosorio.eagle.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(final String userName) {
        return userRepository.findByUserNameAndEnabledIsTrue(userName)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.user.username-not-exists", userName)
                        .build());
    }
}
