package cn.ilongfei.quickweb.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Field extends AbstractPersistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3339829754329581249L;

	/**
	 * 字段
	 */
	private String field;

	/**
	 * 字段名称
	 */
	private String fieldName;

	/**
	 * 字段值
	 */
	private String valueField;

	/**
	 * 字段显示值
	 */
	private String displayField;

	/**
	 * 是否启用
	 */
	private Short enabled;

	/**
	 * 排序
	 */
	private Short sort;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getDisplayField() {
		return displayField;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	public Short getEnabled() {
		return enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	
}