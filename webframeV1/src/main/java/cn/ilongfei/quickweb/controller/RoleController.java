package cn.ilongfei.quickweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ilongfei.quickweb.model.Role;
import cn.ilongfei.quickweb.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends AbstractController<Role> {
	private static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);

	@Autowired
	public void setRoleService(RoleService service){
		modelService = service;
	}
}
