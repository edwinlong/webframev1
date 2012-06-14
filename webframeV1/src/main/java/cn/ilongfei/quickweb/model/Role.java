package cn.ilongfei.quickweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Role extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -3580958115383050988L;
	private String roleName;
	private String roleDesc;
	
	@ManyToMany
	/*@CollectionId(
	    columns = @Column(name = "id"),
	    type = @org.hibernate.annotations.Type(type = "long"),
	    generator = "auto"
	)*/
	@JoinTable(
	    name = "RoleModule",
	    joinColumns = {@JoinColumn(name = "roleId")},
	    inverseJoinColumns = {@JoinColumn(name = "moduleId")}
	)
	private Set<Module> modules = new HashSet<Module>();
	
	public Set<Module> getModules() {
		return modules;
	}
	public void setModules(Set<Module> modules) {
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
