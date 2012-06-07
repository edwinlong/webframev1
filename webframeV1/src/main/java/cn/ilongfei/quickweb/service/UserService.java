package cn.ilongfei.quickweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User findById(Long userId){
		return userRepository.findOne(userId);
	}
	
	public void delete(Long userId){
		userRepository.delete(userId);
	}
	
	public void deleteAll(){
		userRepository.deleteAll();
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public Page<User> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
