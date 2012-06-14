package cn.ilongfei.quickweb.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Role extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -3580958115383050988L;
	private String roleName;
	private String roleDesc;
	
	@ManyToMany
	@CollectionId(
	    columns = @Column(name = "id"),
	    type = @org.hibernate.annotations.Type(type = "long"),
	    generator = "increment"
	)
	@JoinTable(
	    name = "RoleModule",
	    joinColumns = {@JoinColumn(name = "roleId")},
	    inverseJoinColumns = {@JoinColumn(name = "moduleId")}
	)
	private Collection<Module> modules = new ArrayList<Module>();
	
	public Collection<Module> getModules() {
		return modules;
	}
	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
