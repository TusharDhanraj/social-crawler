package com.crawler.socialcrawler.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

public class BaseEntity implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -5225889312002026565L;
	@Indexed
	@Id
	private ObjectId _id;
	@Version
	private Long _version;
	private String createdBy;
	@Indexed
	private Long createdDate;
	private String modifiedBy;
	private Long modifiedDate;

	@Override
	public String toString() {
		return "BaseEntity [_id=" + _id + ", _version=" + _version
				+ ", crtdby=" + createdBy + ", crtddt=" + createdDate
				+ ", modby=" + modifiedBy + ", moddt=" + modifiedDate;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long get_version() {
		return _version;
	}

	public void set_version(Long _version) {
		this._version = _version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
