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

import com.crawler.socialcrawler.entity.UserPost;

/**
 * @author tbhendar
 *
 */

@Component
public class PostUtils {

	@Value("${chrome.driver.path}")
	private String drivelPath;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PostUtils.class);

	public List<UserPost> getUserPostsByUrl(String url) {

		System.setProperty("webdriver.chrome.driver", drivelPath);

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		List<UserPost> userPostVOList = new ArrayList<>();
		try {
			WebElement webElement = driver.findElement(By
					.id("pagelet_timeline_main_column"));

			if (webElement != null) {

				List<WebElement> fbUserContentElements = webElement
						.findElements(By
								.cssSelector("div[class='fbUserContent _5pcr']"));

				for (WebElement fbUserContent : fbUserContentElements) {

					UserPost userPostVO = new UserPost();

					try {
						String timestampContent = null;
						WebElement timestampContentEle = fbUserContent
								.findElement(By.className("timestampContent"));
						if (null != timestampContentEle) {
							timestampContent = timestampContentEle.getText();
							LOGGER.debug("timestampContent=="
									+ timestampContent);
							userPostVO.setTimePosted(timestampContent);
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}

					// Get Top
					try {
						List<WebElement> topElement = fbUserContent
								.findElements(By
										.cssSelector("div[class='_5pbx userContent']"));

						if (null != topElement) {
							if (topElement != null) {
								for (WebElement we : topElement) {
									List<WebElement> paraElements = we
											.findElements(By.tagName("p"));
									StringBuilder DESCRIPTION = new StringBuilder();
									for (WebElement para : paraElements) {
										DESCRIPTION.append(para.getText());
										DESCRIPTION.append("\n");
										LOGGER.debug("Para==" + para.getText());
									}

									userPostVO.setDescription(DESCRIPTION
											.toString());
								}
							}
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}

					// Get News link
					try {
						List<WebElement> linkElements = fbUserContent
								.findElements(By
										.cssSelector("div[class='_3x-2']"));
						String linkUrl = null;
						if (null != linkElements) {
							for (WebElement link : linkElements) {
								List<WebElement> linkTags = link
										.findElements(By.tagName("a"));
								if (linkTags != null) {
									StringBuilder LINKs = new StringBuilder();
									for (WebElement lag : linkTags) {
										linkUrl = lag.getAttribute("href");
										LINKs.append(linkUrl);
										LINKs.append("\n");
										LOGGER.debug("linkUrl = " + linkUrl);
									}
									userPostVO.setHrefs(linkUrl.toString());
								}
							}
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}

					// Get Likes
					try {
						WebElement likeElement = fbUserContent
								.findElement(By
										.cssSelector("div[class='UFILikeSentenceText']"));
						if (null != likeElement) {
							String likes = likeElement.getText();
							LOGGER.debug("Like = " + likes);
							userPostVO.setLikes(likes);
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}

					// Get Shares
					try {
						WebElement sharesElement = fbUserContent.findElement(By
								.cssSelector("a[class='UFIShareLink']"));
						if (null != sharesElement) {
							String shares = sharesElement.getText();
							LOGGER.debug("shares==" + shares);
							userPostVO.setShares(shares);
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}

					// Get Comments
					try {
						WebElement commentsElement = fbUserContent
								.findElement(By
										.cssSelector("div[class='_3b-9']"));
						if (null != commentsElement) {
							String comments = commentsElement.getText();
							LOGGER.debug("comments==" + comments);
							userPostVO.setComments(comments);
						}
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
					userPostVOList.add(userPostVO);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return userPostVOList;

	}
}
