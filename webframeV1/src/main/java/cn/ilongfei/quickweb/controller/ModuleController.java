package cn.ilongfei.quickweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ilongfei.quickweb.model.Module;
import cn.ilongfei.quickweb.service.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController extends AbstractController<Module> {
	private static final Logger logger = LoggerFactory
			.getLogger(ModuleController.class);
	@Autowired
	public void setModuleService(ModuleService service){
		modelService = service;
	}
}
