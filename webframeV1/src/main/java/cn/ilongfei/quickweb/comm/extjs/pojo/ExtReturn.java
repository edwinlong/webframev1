package cn.ilongfei.quickweb.comm.extjs.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * Ext Ajax返回对象
 * 
 * @author chenxin
 * @date 2011-3-10 下午09:43:35
 */
public class ExtReturn {
	
	public static String SUCCESS_MDG = "操作成功";
	public static String FAILURE_MDG = "操作失败";
	
	
	public static Map<String,Object> mapOK(Page page){
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		modelMap.put("data", page.getContent());
		modelMap.put("size", page.getSize());
		modelMap.put("number", page.getNumber());
		modelMap.put("totalPages", page.getTotalPages());
		modelMap.put("numberOfElements", page.getNumberOfElements());
		modelMap.put("totalElements", page.getTotalElements());
		modelMap.put("firstPage", page.isFirstPage());
		modelMap.put("lastPage", page.isLastPage());
		return modelMap;
	}
	
	public static Map<String,Object> mapOK(){
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	
	//操作成功，返回单个对象，自动封装成List
	public static Map<String,Object> mapOK(Object data){
		ArrayList list = new ArrayList();
		list.add(data);
		return mapOK(list, list.size());
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	public static Map<String,Object> mapOK(List data, int total){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("totalElements", total);
		modelMap.put("data", data);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 

}
