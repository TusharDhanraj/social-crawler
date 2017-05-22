/**
 * 
 */
package com.crawler.socialcrawler.repo;

import java.io.Serializable;

import com.crawler.socialcrawler.entity.UserPost;

/**
 * @author tbhendar
 *
 */
public interface UserPostDetailsRepo extends
		MongoRepository<UserPost, Serializable> {

}
