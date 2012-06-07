package cn.ilongfei.quickweb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import cn.ilongfei.quickweb.comm.test.base.ServicesTestBase;
import cn.ilongfei.quickweb.model.User;


/**
 * 
 * 
 * @author chenxin
 * @date 2011-12-7 下午2:27:04
 */
public class UserServiceTest extends ServicesTestBase {

	@Autowired
	private UserService userService;

	
	
	@Before
	public void setup(){
		for(int i=1; i<=12; i++){
			User user = new User();
			user.setFirstname("firstname" + i);
			user.setLastname("lastname" + i);
			user.setUsername("username" + i);
			user = userService.save(user);
			System.out.println("UserId: " + user.getId());
		}
	}
	
	@After
	public void teardown(){
		userService.deleteAll();
	}
	
	@Test
	public void findAll() {
		/*Criteria criteria = new Criteria();
		Tree tree = baseModulesService.selectAllModules(criteria);
		assertNotNull(tree);*/
		List<User> list = userService.findAll();
		assertEquals(list.size(), 12);
	}
	
	@Test
	public void findByUsername() {
		String username = "username3";
		User user = userService.findByUsername(username);
		assertNotNull(user);
		assertEquals(user.getFirstname(),"firstname3");
	}
	
	@Test
	public void findAllPageable() {
		Pageable pageable = new PageRequest(0, 2);
		Page page = userService.findAll(pageable);
		assertNotNull(page);
		assertEquals(page.getTotalElements(),12);
		User user = (User)page.getContent().get(0);
		assertEquals(user.getFirstname(),"firstname1");
	}
	
}
