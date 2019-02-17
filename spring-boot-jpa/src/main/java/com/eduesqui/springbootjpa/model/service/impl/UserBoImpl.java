package com.eduesqui.springbootjpa.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduesqui.springbootjpa.model.dao.IUserDao;
import com.eduesqui.springbootjpa.model.entitys.UserEntity;
import com.eduesqui.springbootjpa.model.service.IUserBo;


@Service
public class UserBoImpl implements IUserBo{

	@Autowired
	private IUserDao userDao;
	

	@Override
	public List<UserEntity> findAll() {
		
		return (List<UserEntity>) userDao.findAll();
	}

	@Override
	public UserEntity findOne(Long id) {
	
		return userDao.findById(id).orElse(null);
		//return userDao.findOne(id);
	}

	@Override
	public void save(UserEntity user) {
		userDao.save(user);
		
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
		//userDao.delete(id);
	}

}
