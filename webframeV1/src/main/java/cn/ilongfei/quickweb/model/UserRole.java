package cn.ilongfei.quickweb.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 用户角色表
 */
@Entity
public class UserRole extends AbstractPersistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632216388621050130L;
	private String userId;
	private String roleId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}