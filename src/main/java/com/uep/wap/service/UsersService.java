package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User UserDTO) {
        User user = new User();
        user.setUsername(UserDTO.getUsername());
        user.setEmail(UserDTO.getEmail());
        user.setPassword(UserDTO.getPassword());
        user.setRole(UserDTO.getRole());
        user.setReputation(UserDTO.getReputation());
        user.setBio(UserDTO.getBio());
        user.setStatus(UserDTO.getStatus());
        user.setCreatedAt(UserDTO.getCreatedAt());
        user.setUpdatedAt(UserDTO.getUpdatedAt());
        userRepository.save(user);
        System.out.println("Users added!");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
