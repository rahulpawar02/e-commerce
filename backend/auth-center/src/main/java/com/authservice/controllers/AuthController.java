package com.authservice.controllers;

import com.authservice.domain.AuthRequest;
import com.authservice.domain.AuthResponse;
import com.authservice.domain.User;
import com.authservice.security.JwtUserDetailService;
import com.authservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
//import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
	
	@Autowired
    private JwtUserDetailService userDetailService;
	
	@Autowired  @Lazy
    private UserService userService;
	
//    private final StreamBridge streamBridge;

    static final String USER_CREATED_OUTPUT = "userCreatedOutput";

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) throws Exception {
        return userDetailService.createJwtToken(request);
    }

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user) {
        User newUser = userService.createNewUser(user);
        //temporary skip the kafka call
//        UserEvent userEvent = UserEvent.builder().username(newUser.getUsername()).email(newUser.getEmail()).build();
//        boolean sent = streamBridge.send(USER_CREATED_OUTPUT, userEvent);
//        System.out.println("Message sent " + sent);
        return newUser;
    }
}
