package cn.ilongfei.quickweb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ilongfei.quickweb.comm.extjs.pojo.ExtReturn;
import cn.ilongfei.quickweb.service.AbstractService;


public abstract class AbstractController<T, S extends AbstractService> {
	@Autowired
	S modelService;

	//list page
	//extjs grid 的分页从1开始，后台是从0开始，这里要把传过来的参数-1
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> list(@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value = "size", required = false) Integer size) {
		if(page==null)page=0;
		if(page>0)page--;
		if(size==null)size=10;
		Pageable pageable = new PageRequest(page,size);
		Page<T> retPage = modelService.list(pageable);
		return ExtReturn.mapOK(retPage);
	}

	//get model by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getUserById(@PathVariable Long id) {
		T model = (T)modelService.get(id); 
		return ExtReturn.mapOK(model);
	}
	
	// create model
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody  T model) {
		T _model = (T)modelService.save(model);
		return ExtReturn.mapOK(_model);
	}

	// update model info by id
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable Long id, @RequestBody  T model) {
		T _model = (T)modelService.save(model);
		return ExtReturn.mapOK(_model);
	}

	// delete model 
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable Long id) {
		modelService.delete(id);
		return ExtReturn.mapOK();
	}

}
