/**
 * 
 */
package com.crawler.socialcrawler.repo.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.crawler.socialcrawler.entity.UserPost;
import com.crawler.socialcrawler.repo.UserPostDetailsRepo;

/**
 * @author tbhendar
 *
 */
@Repository("userPostDetailsRepo")
public class UserPostDetailsRepoImpl extends
		MongoRepositoryImpl<UserPost, Serializable> implements
		UserPostDetailsRepo {

}
