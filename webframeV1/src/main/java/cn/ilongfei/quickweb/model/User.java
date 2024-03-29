package cn.ilongfei.quickweb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -2952735933715107252L;

    @Column(unique = true)
    private String account;
	private String password;
	private String realName;
	private Short sex;
	private String email;
	private String mobile;
	private String officePhone;
	private Short errorCount;
	private Date lastLoginTime;
	private String lastLoginIp;
	private String remark;
	
	@ManyToMany
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//javax.persistence.GenerationType
	/*@javax.persistence..SequenceGenerator(
			name="<logical sequence name>",
			sequenceName="<actual database object name>")*/
	@CollectionId(
	    columns = @Column(name = "id"),
	    type = @org.hibernate.annotations.Type(type = "long"),
	    generator = "increment"
	)
	@JoinTable(
	    name = "UserRole",
	    joinColumns = {@JoinColumn(name = "userId")},
	    inverseJoinColumns = {@JoinColumn(name = "roleId")}
	)
	private Collection<Role> roles = new ArrayList<Role>();
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public Short getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(Short errorCount) {
		this.errorCount = errorCount;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}