package com.greenfoxacademy.masterwork;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Data listing")
public class TC07_Pagination extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC07_Pagination.class);
  Date lastPostsDateOnFirstPage;
  Date firstPostsDateOnSecondPage;

  @Test
  @DisplayName("#TC07_PAGINATION")
  @Description("Navigate to older posts on Greenfox test-automation-blog.")
  public void pagination() throws ParseException {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Getting issue date of last post on current page.");
    lastPostsDateOnFirstPage = homePage.getDateOfLastListedPost();
    LOG.info("Navigating to older posts.");
    homePage.getOlderPostsButton().click();
    LOG.info("Checking if correct page opened.");
    assertThat(secondPage.getTitle()).isEqualTo("Greenfox test-automation-blog – Page 2 – Hello, World! \uD83D\uDC4B");
    LOG.info("Getting issue date of first post on current page.");
    firstPostsDateOnSecondPage = secondPage.getDateOfFirstListedPost();
    LOG.info("Checking if the current page's first post is older or has an identical date as last page's last post.");
    assertThat(lastPostsDateOnFirstPage).isAfterOrEqualTo(firstPostsDateOnSecondPage);
    LOG.info("Posts are in the correct order after pagination.");
  }
}
