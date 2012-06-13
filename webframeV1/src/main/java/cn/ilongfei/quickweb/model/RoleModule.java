package cn.ilongfei.quickweb.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 角色模块表
 */
@Entity
public class RoleModule extends AbstractPersistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6655741432079755705L;
	private String roleId;
	private Integer moduleId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
}