package cn.ilongfei.quickweb.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ilongfei.quickweb.comm.extjs.pojo.ExtReturn;
import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	// for test
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(HttpSession session, Locale locale) {
		return "Hello world";
	}
	
	// for test
	@RequestMapping("/init")
	@ResponseBody
	public String initTestData(HttpSession session, Locale locale) {
		for(int i=1; i<=12; i++){
			User user = new User();
			user.setFirstname("firstname" + i);
			user.setLastname("lastname" + i);
			user.setUsername("username" + i);
			user = userService.save(user);
		}
		return "Init test data successed！";
	}
	
	// get all users
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page index(@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value = "size", required = false) Integer size) {
		if(page==null)page=0;
		if(size==null)size=10;
		Pageable pageable = new PageRequest(page,size);
		Page retPage = userService.findAll(pageable);
		return retPage;
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable Long userId) {
		User user = userService.findById(userId); 
		return user;
	}
	
	// create user
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public User create() {
		User user = null;
		return userService.save(user);
	}

	// update user info by id, 未完，怎样从很中获取对象？
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public User update() {
		User user = null;
		return userService.save(user);
	}

	// delete user 
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ExtReturn delete(@PathVariable Long userId) {
		userService.delete(userId);
		return ExtReturn.SUCCESS;
	}

}
