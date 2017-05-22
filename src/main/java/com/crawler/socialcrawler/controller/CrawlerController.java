/**
 * 
 */
package com.crawler.socialcrawler.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crawler.socialcrawler.entity.UserPost;
import com.crawler.socialcrawler.service.UserPostDetailsService;

/**
 * @author tbhendar
 *
 */
@RestController
@RequestMapping("/user/post")
public class CrawlerController {
	@Autowired
	UserPostDetailsService userPostDetailsService;

	@RequestMapping(value = "read", method = { RequestMethod.POST })
	public Object readUserPostDetails(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userPostDetailsService.saveUserPostDetails();
		return null;

	}

	@RequestMapping(value = "get", method = { RequestMethod.GET })
	public Object getUserPostDetails(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<UserPost> posts = userPostDetailsService.getUserPostDetails();
		return posts;

	}
}
