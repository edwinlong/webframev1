package cn.ilongfei.quickweb.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ilongfei.quickweb.model.User;
import cn.ilongfei.quickweb.repository.UserRepository;
import cn.ilongfei.quickweb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController<User> {
	@Autowired
	public void setUserService(UserService service){
		modelService = service;
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

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
		for (int i = 1; i <= 12; i++) {
			User user = new User();
			user.setAccount("account" + i);
			user.setRealName("realname" + i);
			user.setPassword("123");
			user.setEmail("email" + i + "@111.com");
			user.setMobile("123456700" + i);
			user = modelService.save(user);
		}
		return "Init test data successed!";
	}

}
