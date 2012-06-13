package cn.ilongfei.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.quickweb.model.Field;

public interface FieldRepository extends JpaRepository<Field,Long>{
	
}
