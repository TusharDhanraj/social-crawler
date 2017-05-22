/**
 * 
 */
package com.crawler.socialcrawler.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crawler.socialcrawler.entity.UserPost;

/**
 * @author tbhendar
 *
 */
public class FacebookDetailsUtilsWithOutLogin {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FacebookDetailsUtilsWithOutLogin.class);

	public static void main(String[] args) throws IOException {
		String expath = "C:/Users/tbhendar/Downloads/chromedriver_win32/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", expath);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/KashmirMonitor/");

		List<WebElement> webElements = driver.findElement(By.id("u_0_4j"))
				.findElements(By.tagName("div"));
		driver.getPageSource();
		List<UserPost> userPostVOList = new ArrayList<>();
		for (WebElement webElement : webElements) {

			try {

				UserPost userPostVO = new UserPost();
				webElement.getAttribute("innerHTML");

				String postedOn = null;
				WebElement time = webElement.findElement(By.tagName("abbr"));
				if (time != null) {
					postedOn = time.getAttribute("title");
					userPostVO.setTimePosted(postedOn);
				}

				String views = null;
				views = webElement.findElement(By.id("u_0_10")).getText();

				userPostVO.setTotalViews(views);

				userPostVO.setDescription(webElement.getText());
				userPostVOList.add(userPostVO);

			} catch (Exception e) {
				LOGGER.error("Element not found!", e);
			}
		}

	}
}
