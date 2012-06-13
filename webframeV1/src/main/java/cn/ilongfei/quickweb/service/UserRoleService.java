package cn.ilongfei.quickweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.quickweb.model.UserRole;
import cn.ilongfei.quickweb.repository.UserRoleRepository;


@Service
public class UserRoleService extends AbstractService<UserRole>{
	
	UserRoleRepository userRoleRepository;
	
	@Autowired
	public void setRoleReposity(UserRoleRepository userRoleRepository){
		repository = userRoleRepository;
		this.userRoleRepository = userRoleRepository;
	} 
}
