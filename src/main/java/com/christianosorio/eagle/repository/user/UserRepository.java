package com.christianosorio.eagle.repository.user;

import com.christianosorio.eagle.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserNameAndEnabledIsTrue(String userName);

    @Query(value = "select u from User u where  u.userName=:userName and u.password=:userPassword and u.enabled is true")
    Optional<User> authUser(String userName, String userPassword);
}
