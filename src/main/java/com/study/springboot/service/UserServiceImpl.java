package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.study.springboot.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Map<Long, User> userRepository = new ConcurrentHashMap<>();
	
	public UserServiceImpl(){
		userRepository.put(1L, new User(1L, "waylau", 30));
		userRepository.put(2L, new User(2L,"老卫", 29));
		userRepository.put(3L, new User(3L,"doufe", 109));
	}
	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.security.service.UserService#removeUser(java.lang.Long)
	 */
	@Override
	public void removeUser(Long id) {
		userRepository.remove(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.security.service.UserService#listUsers()
	 */
	@Override
	public List<User> listUsers() {
		List<User> users = null;
		users = new ArrayList<User>(userRepository.values()); 
		return users;
	}

}
