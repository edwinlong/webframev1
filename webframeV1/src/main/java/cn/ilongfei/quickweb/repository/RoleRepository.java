package cn.ilongfei.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.quickweb.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	
}
