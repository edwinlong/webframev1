package cn.ilongfei.quickweb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import cn.ilongfei.quickweb.comm.test.base.ServicesTestBase;
import cn.ilongfei.quickweb.model.Module;
import cn.ilongfei.quickweb.model.Role;
import cn.ilongfei.quickweb.model.Tree;
import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.service.util.TreeMenu;


/**
 * 
 * 
 * 
 */
public class UserServiceTest extends ServicesTestBase {

	@Autowired
	private UserService userService;

	
	
	@Before
	public void setup(){
		/*for(int i=1; i<=12; i++){
			User user = new User();
			user.setAccount("account" + i);
			user.setRealName("realname" + i);
			user.setPassword("123");
			user.setEmail("email"+i+"@111.com");
			user.setMobile("123456700"+i);
			user = userService.save(user);
			System.out.println("UserId: " + user.getId());
		}*/
	}
	
	@After
	public void teardown(){
		//userService.deleteAll();
	}
	/**
	 * 打印第一个用户所拥有的菜单
	 */
	@Ignore
	public void findAll() {
		/*Criteria criteria = new Criteria();
		Tree tree = baseModulesService.selectAllModules(criteria);
		assertNotNull(tree);*/
		List<User> list = userService.listAll();
		User user = (User)list.get(0);
		Iterator roles = user.getRoles().iterator();
		while(roles.hasNext()){
			Role role = (Role)roles.next();
			System.out.println(role.getRoleName());
			Iterator modules = role.getModules().iterator();
			while(modules.hasNext()){
				Module module = (Module)modules.next();
				System.out.println(module.getModuleName());
			}
		}
	}
	
	@Test
	public void getModuleTree(){
		String account = "admin";
		User user = userService.findByAccount(account);
		TreeMenu treeMenu = new TreeMenu(user);
		Tree root = treeMenu.getTreeJson();
		//admin用户有2个一级菜单
		assertEquals(root.getChildren().size(),2);
		//System.out.println(root.getId());
	}
	
	@Test
	public void findByAccount() {
		String account = "admin";
		User user = userService.findByAccount(account);
		assertNotNull(user);
		assertEquals(user.getRealName(),"超级管理员");
	}
	
	@Test
	public void findAllPageable() {
		Pageable pageable = new PageRequest(0, 2);
		Page<User> page = userService.list(pageable);
		assertNotNull(page);
		//assertEquals(page.getTotalElements(),12);
		User user = (User)page.getContent().get(0);
		assertEquals(user.getRealName(),"测试用户");
	}
	
}
