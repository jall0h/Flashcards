package com.codingwithabu.backend;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    //SELECT * from student WHERE email = ?
    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    Optional<User> findUserByFirstName(String firstName);
}
