package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();
	
	List<UserProfile> getUserProfile(User user);
	
	User findByEmail(String email);

}

