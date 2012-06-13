package cn.ilongfei.quickweb.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
public class Module extends AbstractPersistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5932141516258870364L;
	private String moduleName;
	private String moduleUrl;
	private Integer parentId;

	/**
	 * 叶子节点(0:树枝节点;1:叶子节点)
	 */
	private Short leaf;

	/**
	 * 展开状态(1:展开;0:收缩)
	 */
	private Short expanded;

	/**
	 * 显示顺序
	 */
	private Short displayIndex;

	/**
	 * 是否显示 0:否 1:是
	 */
	private Short isDisplay;

	/**
	 * 模块英文名称
	 */
	private String enModuleName;

	/**
	 * 图标或者样式
	 */
	private String iconCss;

	/**
	 * 节点说明
	 */
	private String information;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Short getLeaf() {
		return leaf;
	}

	public void setLeaf(Short leaf) {
		this.leaf = leaf;
	}

	public Short getExpanded() {
		return expanded;
	}

	public void setExpanded(Short expanded) {
		this.expanded = expanded;
	}

	public Short getDisplayIndex() {
		return displayIndex;
	}

	public void setDisplayIndex(Short displayIndex) {
		this.displayIndex = displayIndex;
	}

	public Short getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Short isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getEnModuleName() {
		return enModuleName;
	}

	public void setEnModuleName(String enModuleName) {
		this.enModuleName = enModuleName;
	}

	public String getIconCss() {
		return iconCss;
	}

	public void setIconCss(String iconCss) {
		this.iconCss = iconCss;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	
	
}