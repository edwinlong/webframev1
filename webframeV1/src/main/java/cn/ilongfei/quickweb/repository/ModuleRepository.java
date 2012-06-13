package cn.ilongfei.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.quickweb.model.Module;

public interface ModuleRepository extends JpaRepository<Module,Long>{
	
}
