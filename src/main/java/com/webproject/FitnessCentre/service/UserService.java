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

    public User findOneUser(String username) {
        User user = this.userRepository.getByUsername(username);
        return  user;
    }

    public boolean checkPass(User user, String password) {
        if(user.getPassword() == password)
            return  true;
        return false;
    }

    public boolean checkProfile(String username, String password){
        List<User> users = findAll();
        for (User tempUser : users) {
            if(tempUser.getUsername() == username){
                if(tempUser.getPassword() == password)
                    return true;
            }
        }
        return  false;
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
