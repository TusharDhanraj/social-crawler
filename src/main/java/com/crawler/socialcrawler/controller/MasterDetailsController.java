/**
 * 
 */
package com.crawler.socialcrawler.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crawler.socialcrawler.service.MasterDetailsService;

/**
 * @author tbhendar
 *
 */
@RestController
@RequestMapping("/master/")
public class MasterDetailsController {

	@Autowired
	MasterDetailsService masterDetailsService;

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Object getMasterDetails(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return masterDetailsService.getMasterDetails();

	}

	@RequestMapping(value = "save", method = { RequestMethod.POST })
	public Object saveMasterDetails(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		masterDetailsService.saveMasterDetails();
		return null;

	}
}
