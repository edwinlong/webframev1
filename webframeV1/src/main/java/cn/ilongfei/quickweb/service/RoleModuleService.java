package cn.ilongfei.quickweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.quickweb.model.RoleModule;
import cn.ilongfei.quickweb.repository.RoleModuleRepository;


@Service
public class RoleModuleService extends AbstractService<RoleModule>{
	RoleModuleRepository roleModuleRepository;
	@Autowired
	public void setRoleReposity(RoleModuleRepository roleModuleRepository){
		repository = roleModuleRepository;
		this.roleModuleRepository = roleModuleRepository;
	} 

}
