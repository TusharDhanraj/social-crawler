/**
 * 
 */
package com.crawler.socialcrawler.service;

import java.util.List;

import com.crawler.socialcrawler.entity.UserPost;

/**
 * @author tbhendar
 *
 */
public interface UserPostDetailsService {
	List<UserPost> getUserPostDetails();

	void saveUserPostDetails();
}
