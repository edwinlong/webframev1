package cn.ilongfei.quickweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ilongfei.quickweb.model.UserRole;
import cn.ilongfei.quickweb.service.UserRoleService;

@Controller
@RequestMapping("/userrole")
public class UserRoleController extends AbstractController<UserRole> {
	private static final Logger logger = LoggerFactory
			.getLogger(UserRoleController.class);
	@Autowired
	public void setUserRoleService(UserRoleService service){
		modelService = service;
	}
}
