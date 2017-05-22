/**
 * 
 */
package com.crawler.socialcrawler.entity;

import java.util.Calendar;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tbhendar
 *
 */
@Document(collection="USER_POSTS")
public class UserPost extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7234233826332673749L;
	private String timePosted;
	private String handler;
	private String description;
	private String imageUrl;
	private String videoUrl;
	private String numOfLikes;
	private String numOfShares;
	private String numOfComments;
	private String recentlyCommented;
	private String totalViews;
	private String recentViewedCommented;
	private Calendar timeStamp;
	private String hrefs;

	private String likes;
	private String shares;
	private String comments;
	private String handlerUrl;

	public String getHandlerUrl() {
		return handlerUrl;
	}

	public void setHandlerUrl(String handlerUrl) {
		this.handlerUrl = handlerUrl;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHrefs() {
		return hrefs;
	}

	public void setHrefs(String hrefs) {
		this.hrefs = hrefs;
	}

	public Calendar getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Calendar timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getNumOfLikes() {
		return numOfLikes;
	}

	public void setNumOfLikes(String numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	public String getNumOfShares() {
		return numOfShares;
	}

	public void setNumOfShares(String numOfShares) {
		this.numOfShares = numOfShares;
	}

	public String getNumOfComments() {
		return numOfComments;
	}

	public void setNumOfComments(String numOfComments) {
		this.numOfComments = numOfComments;
	}

	public String getRecentlyCommented() {
		return recentlyCommented;
	}

	public void setRecentlyCommented(String recentlyCommented) {
		this.recentlyCommented = recentlyCommented;
	}

	public String getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(String totalViews) {
		this.totalViews = totalViews;
	}

	public String getRecentViewedCommented() {
		return recentViewedCommented;
	}

	public void setRecentViewedCommented(String recentViewedCommented) {
		this.recentViewedCommented = recentViewedCommented;
	}
}
