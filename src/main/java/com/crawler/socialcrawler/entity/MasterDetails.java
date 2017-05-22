/**
 * 
 */
package com.crawler.socialcrawler.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tbhendar
 *
 */

@Document(collection = "MASTER_DETAILS")
public class MasterDetails extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6280447344917501760L;
	private String handlerUrl;
	private String name;
	private String description;
	private String logoUrl;

	public String getHandlerUrl() {
		return handlerUrl;
	}

	public void setHandlerUrl(String handlerUrl) {
		this.handlerUrl = handlerUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((handlerUrl == null) ? 0 : handlerUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterDetails other = (MasterDetails) obj;
		if (handlerUrl == null) {
			if (other.handlerUrl != null)
				return false;
		} else if (!handlerUrl.equals(other.handlerUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MasterDetails [handlerUrl=" + handlerUrl + ", name=" + name
				+ ", description=" + description + ", logoUrl=" + logoUrl + "]";
	}

}
