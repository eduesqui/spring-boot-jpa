package com.eduesqui.springbootjpa.model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.eduesqui.springbootjpa.model.entitys.UserEntity;

public interface IUserDao extends CrudRepository<UserEntity, Long> {

	
}
