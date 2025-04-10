package com.example.student_management.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class BaseConverter<Entity, Dto> {
    @Autowired
    private ModelMapper modelMapper;

    public Dto toDto(Entity entity) {
        Type dtoClass = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return modelMapper.map(entity, dtoClass);
    }

    public Entity toEntity(Dto dto) {
        Type entityClass = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return modelMapper.map(dto, entityClass);
    }

    public List<Dto> toDTOGroup(List<Entity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Entity> toEntityGroup(List<Dto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public Page<Dto> toDTOPage(Page<Entity> entities) {
        return entities.map(this::toDto);
    }
}
