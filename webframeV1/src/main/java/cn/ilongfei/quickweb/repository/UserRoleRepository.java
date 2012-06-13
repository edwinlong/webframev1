package cn.ilongfei.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.quickweb.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{
	
}
