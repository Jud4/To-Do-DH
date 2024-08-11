package com.to_app_dh.toDoApp.infrastructure.mappers;

public interface BaseMapper <Entity,Model>{
    Entity toEntity(Model model);
    Model toModel(Entity entity);
}
