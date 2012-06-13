package cn.ilongfei.quickweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ilongfei.quickweb.model.RoleModule;
import cn.ilongfei.quickweb.service.RoleModuleService;

@Controller
@RequestMapping("/rolemodule")
public class RoleModuleController extends AbstractController<RoleModule> {
	private static final Logger logger = LoggerFactory
			.getLogger(RoleModuleController.class);

	@Autowired
	public void setRoleModuleService(RoleModuleService service){
		modelService = service;
	}
}
