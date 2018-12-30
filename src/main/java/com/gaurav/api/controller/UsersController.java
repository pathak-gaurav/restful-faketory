package com.gaurav.api.controller;

import com.gaurav.api.domain.User;
import com.gaurav.api.services.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    private ApiService apiService;

    public UsersController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/users/{limit}")
    public List<User> getUsers(@PathVariable Integer limit){
        return apiService.getUsers(limit);
    }
}
