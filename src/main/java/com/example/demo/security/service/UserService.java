package com.example.demo.security.service;

import com.example.demo.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
