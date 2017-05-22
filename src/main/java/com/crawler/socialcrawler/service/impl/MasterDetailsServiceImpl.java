/**
 * 
 */
package com.crawler.socialcrawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.socialcrawler.entity.MasterDetails;
import com.crawler.socialcrawler.repo.MasterDetailsRepo;
import com.crawler.socialcrawler.service.MasterDetailsService;
import com.crawler.socialcrawler.utils.MasterListUtils;

/**
 * @author tbhendar
 *
 */

@Service("masterDetailsService")
public class MasterDetailsServiceImpl implements MasterDetailsService {

	@Autowired
	MasterListUtils masterListUtils;

	@Autowired
	MasterDetailsRepo masterDetailsRepo;

	@Override
	public List<MasterDetails> getMasterDetails() {

		return masterDetailsRepo.getAll();
	}

	@Override
	public void saveMasterDetails() {
		List<MasterDetails> masterDetailsList = masterListUtils
				.getMasterDetails();

		for (MasterDetails masterDetails : masterDetailsList) {
			masterDetailsRepo.save(masterDetails);
		}
	}

}
