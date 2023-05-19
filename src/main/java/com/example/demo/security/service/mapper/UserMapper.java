package com.example.demo.security.service.mapper;

import com.example.demo.security.entity.User;
import com.example.demo.security.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO mapToDto(User user);

    List<UserDTO> mapToDtos(List<User> users);
}
