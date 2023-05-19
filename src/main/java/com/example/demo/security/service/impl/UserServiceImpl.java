package com.example.demo.security.service.impl;

import com.example.demo.security.service.mapper.UserMapper;
import com.example.demo.security.repository.UserRepository;
import com.example.demo.security.service.UserService;
import com.example.demo.security.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.mapToDtos(userRepository.findAll());
    }
}
