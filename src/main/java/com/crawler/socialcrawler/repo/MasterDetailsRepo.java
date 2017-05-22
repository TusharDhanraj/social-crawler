/**
 * 
 */
package com.crawler.socialcrawler.repo;

import java.io.Serializable;

import com.crawler.socialcrawler.entity.MasterDetails;

/**
 * @author tbhendar
 *
 */
public interface MasterDetailsRepo extends
		MongoRepository<MasterDetails, Serializable> {

}
