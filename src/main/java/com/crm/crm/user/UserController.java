package com.crm.crm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/users")
public class UserController {

    @Autowired UserService userService;


    @PostMapping(path="/add")
    public ResponseEntity<Userr> addNewUser (@RequestBody Userr user) {
        userService.saveUser(user);
        return new ResponseEntity<Userr>(user, HttpStatus.CREATED);
    }

    @PostMapping(path="/login")
    public ResponseEntity<Userr> login (@RequestBody Userr user) {
        Userr u = userService.login(user.getEmail(), user.getPassword());
        if (u != null) {
            return new ResponseEntity<Userr>(u, HttpStatus.OK);
        } else {
            return new ResponseEntity<Userr>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Userr> getAllUsers() {
        return userService.getAllUsers();
    }
}
    

