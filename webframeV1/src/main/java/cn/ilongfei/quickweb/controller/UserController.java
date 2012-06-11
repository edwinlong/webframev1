package cn.ilongfei.quickweb.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
		return "Init test data successed!";
	}
	
	// get all users
	//extjs grid 的分页从1开始，后台是从0开始，这里要把传过来的参数-1
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> index(@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value = "size", required = false) Integer size) {
		if(page==null)page=0;
		if(page>0)page--;
		if(size==null)size=10;
		Pageable pageable = new PageRequest(page,size);
		Page retPage = userService.findAll(pageable);
		return ExtReturn.mapOK(retPage);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getUserById(@PathVariable Long userId) {
		User user = userService.findById(userId); 
		return ExtReturn.mapOK(user);
	}
	
	// create user
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody  User user) {
		User _user = userService.save(user);
		return ExtReturn.mapOK(_user);
	}

	// update user info by id
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable Long userId, @RequestBody  User user) {
		User _user = userService.save(user);
		return ExtReturn.mapOK(_user);
		//return ExtReturn.mapError("测试失败情况！");
	}

	// delete user 
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable Long userId) {
		userService.delete(userId);
		return ExtReturn.mapOK();
	}

}
