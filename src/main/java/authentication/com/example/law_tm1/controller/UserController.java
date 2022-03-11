package authentication.com.example.law_tm1.controller;

import authentication.com.example.law_tm1.model.User;
import authentication.com.example.law_tm1.repository.UserDao;
import authentication.com.example.law_tm1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    //this is more like adding a new user, then use that user rather than normal login
    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return userService.addUser(user);
    }
    
}
