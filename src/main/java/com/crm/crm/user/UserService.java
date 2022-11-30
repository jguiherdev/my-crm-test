package com.crm.crm.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(Userr user) {
        userRepository.save(user);
    }

    public Iterable<Userr> getAllUsers() {
        return userRepository.findAll();
    }

    //login method
    public Userr login(String email, String password) {
        List<Userr> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            Userr u = users.get(i);
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    
}
