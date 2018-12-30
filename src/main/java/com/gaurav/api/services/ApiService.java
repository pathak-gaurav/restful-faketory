package com.gaurav.api.services;

import com.gaurav.api.domain.User;

import java.util.List;

public interface ApiService {

    List<User> getUsers(Integer limit);
}
