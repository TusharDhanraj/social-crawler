/**
 * 
 */
package com.crawler.socialcrawler.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.socialcrawler.entity.MasterDetails;
import com.crawler.socialcrawler.entity.UserPost;
import com.crawler.socialcrawler.repo.UserPostDetailsRepo;
import com.crawler.socialcrawler.service.MasterDetailsService;
import com.crawler.socialcrawler.service.UserPostDetailsService;
import com.crawler.socialcrawler.utils.PostUtils;

/**
 * @author tbhendar
 *
 */

@Service("userPostDetailsService")
public class UserPostDetailsServiceImpl implements UserPostDetailsService {

	@Autowired
	PostUtils postUtils;

	@Autowired
	UserPostDetailsRepo userPostDetailsRepo;

	@Autowired
	MasterDetailsService masterDetailsService;

	@Override
	public List<UserPost> getUserPostDetails() {

		return userPostDetailsRepo.getAll();
	}

	@Override
	public void saveUserPostDetails() {

		List<MasterDetails> masterDetails = masterDetailsService
				.getMasterDetails();

		for (MasterDetails details : masterDetails) {
			List<UserPost> uerPostDetailsList = postUtils
					.getUserPostsByUrl(details.getHandlerUrl());

			for (UserPost userPost : uerPostDetailsList) {
				userPost.setHandler(details.getName());
				userPost.setHandlerUrl(details.getHandlerUrl());

				// Get likes count
				String likes = userPost.getLikes();
				if (StringUtils.isNotBlank(likes)) {
					userPost.setNumOfLikes(likes.replaceAll("[^?0-9]+", ""));
				}

				// Get shares count
				String shares = userPost.getShares();
				if (StringUtils.isNotBlank(shares)) {
					userPost.setNumOfShares(shares.replaceAll("[^?0-9]+", ""));
				}

				// Get comments count
				String comments = userPost.getComments();
				if (StringUtils.isNotBlank(comments)) {
					String commentsArr[] = comments.split("\n");
					if (commentsArr != null && commentsArr.length > 0) {
						String commentedstr = commentsArr[commentsArr.length - 1];

						userPost.setNumOfComments(commentedstr.replaceAll(
								"[^?0-9]+", ""));
					}
				}

				userPostDetailsRepo.save(userPost);
			}
		}

	}

}
