package com.greenfoxacademy.masterwork;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("User data management")
public class TC13_Deleting_data extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC13_Deleting_data.class);

  @Test
  @DisplayName("#TC13_DELETING_DATA")
  @Description("Successful delete of an existing profile description in the edit profile menu (inside account/view profile).")
  public void deletingProfileDescription() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to login page.");
    homePage.getLoginMenuButton().click();
    LOG.info("Logging in with given data.");
    loginPage.login(username, password);
    wait.until(ExpectedConditions.titleContains("Hello, World!"));
    LOG.info("Navigating to account page.");
    homePage.getAccountMenuButton().click();
    LOG.info("Navigating to user page");
    accountPage.getViewProfileLink().click();
    LOG.info("Verifying if correct pade loaded.");
    assertThat(userPage.getTitle()).isEqualTo(firstName + " " + lastName + " | Greenfox test-automation-blog");
    LOG.info("Opening profile edit option.");
    userPage.getSettingsButton().click();
    userPage.getEditProfileMenuButton().click();
    LOG.info("Deleting profile description.");
    userPage.getUserBioField().clear();
    wait.until(ExpectedConditions.visibilityOf(userPage.getUpdateProfileButton()));
    userPage.getUpdateProfileButton().submit();
    LOG.info("Checking if any user description displayed.");
    wait.until(ExpectedConditions.visibilityOf(userPage.getFrownIcon()));
    assertThat(userPage.isUserBioDisplayed()).isFalse();
    Allure.addAttachment("Profile description successfully deleted.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    LOG.info("Deleting profile description was successful.");
  }
}

