/**
 * 
 */
package com.crawler.socialcrawler.repo.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.crawler.socialcrawler.entity.MasterDetails;
import com.crawler.socialcrawler.repo.MasterDetailsRepo;

/**
 * @author tbhendar
 *
 */
@Repository("masterDetailsRepo")
public class MasterDetailsRepoImpl extends
		MongoRepositoryImpl<MasterDetails, Serializable> implements
		MasterDetailsRepo {

}
