/**
 * 
 */
package com.crawler.socialcrawler.service;

import java.util.List;

import com.crawler.socialcrawler.entity.MasterDetails;

/**
 * @author tbhendar
 *
 */
public interface MasterDetailsService {
	List<MasterDetails> getMasterDetails();

	void saveMasterDetails();
}
