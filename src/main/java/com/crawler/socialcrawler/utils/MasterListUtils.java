/**
 * 
 */
package com.crawler.socialcrawler.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.crawler.socialcrawler.entity.MasterDetails;

/**
 * @author tbhendar
 *
 */

@Component
public class MasterListUtils {

	@Value("${chrome.driver.path}")
	private String drivelPath;

	@Value("{master.data.search.url}")
	private String searchUrl;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MasterListUtils.class);

	public List<MasterDetails> getMasterDetails() {

		System.setProperty("webdriver.chrome.driver", drivelPath);

		WebDriver driver = new ChromeDriver();

		driver.get(searchUrl);

		List<MasterDetails> masterDetails = new ArrayList<MasterDetails>();

		List<WebElement> webElements = driver.findElement(
				By.id("all_search_results")).findElements(By.tagName("div"));

		for (WebElement webElement : webElements) {
			MasterDetails details = new MasterDetails();
			String logoUrl = null;

			try {
				WebElement img = webElement.findElement(By.tagName("img"));
				if (img != null) {
					logoUrl = img.getAttribute("src");
					details.setLogoUrl(logoUrl);
				}

				String handlerUrl = null;
				WebElement anchor = webElement.findElement(By.tagName("a"));
				if (anchor != null) {
					handlerUrl = anchor.getAttribute("href");
					details.setHandlerUrl(handlerUrl);
				}

				String description = webElement.getText();
				details.setDescription(description);
				if (null != description) {
					String arr[] = description.split("\n", 2);
					description.split("\n", 2);
					if (arr != null)
						details.setName(arr[0]);
				}
				if (!masterDetails.contains(details))
					masterDetails.add(details);
			} catch (Exception e) {
				LOGGER.error("Element not found", e);
			}

		}
		return masterDetails;

	}

}
