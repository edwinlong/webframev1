package cn.ilongfei.quickweb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public abstract class AbstractService<T> {
	
	protected JpaRepository<T, Long> repository;

	public T create(T model) {
		return repository.save(model);
	}


	public T get(Long id) {
		return repository.findOne(id);
	}


	public Page<T> list(Pageable pageable) {
		return repository.findAll(pageable);
	}


	public List<T> listAll() {
		return repository.findAll();
	}


	public T save(T model) {
		return repository.save(model);
	}


	public void delete(Long id) {
		repository.delete(id);
	}


	public void deleteAll() {
		repository.deleteAll();
	}
}
