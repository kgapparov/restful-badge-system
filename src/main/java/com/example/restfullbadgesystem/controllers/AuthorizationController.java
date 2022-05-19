package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.service.FetchDataFromJwt;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private FetchDataFromJwt service;

    @GetMapping
    @RolesAllowed({"user", "admin"})
    public Map<String, AccessToken.Access> get(){
        return service.getResourceAccess();
    }
    @GetMapping("/whoami")
    @RolesAllowed({"user", "admin"})
    public String whoAmI(){
        return service.getUsername() + " " + service.getEmail();
    }
}
