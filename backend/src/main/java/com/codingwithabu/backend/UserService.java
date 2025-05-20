package com.codingwithabu.backend;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public void addNewUser(User user) {
       Optional<User> userOptional = userRepository.findUserByFirstName(user.getFirstName());
       if (userOptional.isPresent()) {
        throw new IllegalStateException("user taken");
       }
       System.out.println(user);
       userRepository.save(user);
    }

}
