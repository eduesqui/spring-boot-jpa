package com.eduesqui.springbootjpa.model.service;

import java.util.List;

import com.eduesqui.springbootjpa.model.entitys.UserEntity;

public interface IUserBo {
	
	public List<UserEntity> findAll();
	
	public UserEntity findOne(Long id);
	
	public void save(UserEntity user);
	
	public void delete(Long id);
	

}
