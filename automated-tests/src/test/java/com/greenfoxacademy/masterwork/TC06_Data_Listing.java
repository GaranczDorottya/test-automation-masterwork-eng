package com.greenfoxacademy.masterwork;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Data listing")
public class TC06_Data_Listing extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC06_Data_Listing.class);

  @Test
  @DisplayName("#TC06_DATA_LISTING")
  @Description("List all blog posts issued 02. July 2021. on Greenfox test-automation-blog.")
  public void successfulDataListing() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to older posts.");
    homePage.getOlderPostsButton().click();
    LOG.info("Opening Hello world! blog post.");
    secondPage.getContinueReadingButton().click();
    LOG.info("Filtering posts from July 2, 2021");
    blogPostPage.getButton2().click();
    assertThat(archivePage.getTitle()).isEqualTo("July 2, 2021 – Greenfox test-automation-blog");
    LOG.info("Checking dates on filtered posts.");
    archivePage.checkPostsDate();
    LOG.info("Checking if filtered post amount is correct.");
    assertThat(archivePage.getPostsOnPage().size()).isEqualTo(1);
    LOG.info("Filtering was successful");
  }
}

