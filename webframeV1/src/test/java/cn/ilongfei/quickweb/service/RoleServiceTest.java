package cn.ilongfei.quickweb.service;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ilongfei.quickweb.comm.test.base.ServicesTestBase;
import cn.ilongfei.quickweb.model.Module;
import cn.ilongfei.quickweb.model.Role;
import cn.ilongfei.quickweb.model.User;


/**
 * 
 * 
 * 
 */
public class RoleServiceTest extends ServicesTestBase {

	@Autowired
	private RoleService roleService;

	
	
	@Before
	public void setup(){
	}
	
	@After
	public void teardown(){
	}
	
	@Test
	public void findAll() {
		List<Role> list = roleService.listAll();
		Role role = (Role)list.get(0);
		Iterator modules = role.getModules().iterator();
		while(modules.hasNext()){
			Module module = (Module)modules.next();
			System.out.println(module.getModuleName());
			//System.out.println(module.getModuleDesc());
		}
	}
	
}
