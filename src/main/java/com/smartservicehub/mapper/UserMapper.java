package com.smartservicehub.mapper;

import com.smartservicehub.constant.Role;
import com.smartservicehub.dto.UserDto;
import com.smartservicehub.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
       return UserDto.builder().name(user.getName())
                .id(user.getId())
                .email(user.getEmail())
                .role(String.valueOf(user.getRole()))
                .avatarUrl(user.getAvatarUrl())
                .build();
    }

    public User toEntity(UserDto userDto){
        return User.builder().name(userDto.getName())
                .id(userDto.getId())
                .email(userDto.getEmail())
                .role(Role.valueOf(userDto.getRole()))
                .avatarUrl(userDto.getAvatarUrl())
                .password("abcd@1234")
                .build();
    }
}
