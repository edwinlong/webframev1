package cn.ilongfei.quickweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ilongfei.quickweb.model.Field;
import cn.ilongfei.quickweb.service.FieldService;

@Controller
@RequestMapping("/datadict")
public class DataDictController extends AbstractController<Field> {
	private static final Logger logger = LoggerFactory
			.getLogger(DataDictController.class);
	
	@Autowired
	public void setFieldService(FieldService service){
		modelService = service;
	}
}
