package com.example.Bootcamp.SinauKoding.model.mapper;

import com.example.Bootcamp.SinauKoding.model.DetailUser;
import com.example.Bootcamp.SinauKoding.model.dto.DetailUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailUserMapper {
    DetailUserMapper INSTANCE = Mappers.getMapper(DetailUserMapper.class);

    DetailUser toEntity(DetailUserDTO dto);

    DetailUserDTO toDTO(DetailUser data);
}
