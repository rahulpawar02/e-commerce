package com.authservice.controllers;

import com.authservice.domain.Role;
import com.authservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/roles")
    public Role createNewRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
