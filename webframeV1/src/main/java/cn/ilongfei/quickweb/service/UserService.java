package cn.ilongfei.quickweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.repository.UserRepository;


@Service
public class UserService implements AbstractService<User>{
	@Autowired
	UserRepository userRepository;
	
	/*public User findById(Long userId){
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
	
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}*/

	@Override
	public User create(User model) {
		return userRepository.save(model);
	}

	@Override
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> list(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User model) {
		return userRepository.save(model);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
		
	}
	
	/*
	 * 按帐号查找。account = username
	 */
	public User findByAccount(String account){
		return userRepository.findByAccount(account);
	}
}
