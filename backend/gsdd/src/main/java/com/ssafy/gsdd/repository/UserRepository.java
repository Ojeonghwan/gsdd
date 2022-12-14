package com.ssafy.gsdd.repository;

import com.ssafy.gsdd.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @EntityGraph(attributePaths = {"contacts"})
    User findByUserId(int id);

    Optional<User> findByEmail(String email);

}