package com.study.springboot.service;

import com.study.springboot.domain.User;

import java.util.List;


/**
 * User 服务接口.
 * 
 * @since 1.0.0 2017年3月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface UserService {

	void removeUser(Long id);
	
	List<User> listUsers();
}
