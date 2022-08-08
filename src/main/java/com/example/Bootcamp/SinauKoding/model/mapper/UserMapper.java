package com.example.Bootcamp.SinauKoding.model.mapper;

import com.example.Bootcamp.SinauKoding.model.User;
import com.example.Bootcamp.SinauKoding.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "profileName")
    User toEntity(UserDTO dto);

    @Mapping(source = "profileName", target = "name")
    UserDTO toDto(User data);

    List<UserDTO> toListDTO(List<User> list);

    List<User> toListEntity(List<UserDTO> data);
}
