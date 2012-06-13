package cn.ilongfei.quickweb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.ilongfei.quickweb.model.User;
public interface AbstractService<T> {

	public T create(T model);
	
	public T get(Long id);
	
	public T save(T model);
	
	public void delete(Long id);
	
	public Page<T> list(Pageable pageable);
	
	public List<User> listAll();
	
	public void deleteAll();
}
