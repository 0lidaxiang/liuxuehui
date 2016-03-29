package com.liuxue.base.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author 李成龙
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	
	private String guid;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "com.liuxue.base.entity.UUIDStringGenerator")
	@Column(length=32)
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}


	@Transient
	public boolean isTransient() {
		return StringUtils.isEmpty(guid);
	}

	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.MULTI_LINE_STYLE).append("guid", this.guid);
		return sb.toString();
	};

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BaseEntity)) {
			return false;
		}
		final BaseEntity object = (BaseEntity) o;
		if (guid != null && object.getGuid() != null
				&& guid.equals(object.getGuid())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (guid != null ? guid.hashCode() : 0);
	};
}
