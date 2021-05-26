package com.webproject.FitnessCentre.service;

import com.webproject.FitnessCentre.entity.User;
import com.webproject.FitnessCentre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findOne(Long id) {
        User user = this.userRepository.getOne(id);
        return user;
    }

    public List<User> findAll() {
        List<User> user = this.userRepository.findAll();
        return user;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
