package cn.ilongfei.quickweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.repository.UserRepository;


@Service
public class UserService extends AbstractService<User>{
	
	UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository){
		repository = userRepository;
		this.userRepository = userRepository;
	}
	
	/*
	 * 按帐号查找。account = username
	 */
	public User findByAccount(String account){
		return userRepository.findByAccount(account);
	}
}
