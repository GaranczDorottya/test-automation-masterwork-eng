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
public class TC08_Data_Input extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC08_Data_Input.class);

  @Test
  @DisplayName("#TC08_DATA_INPUT_01")
  @Description("Add a profile description to an existing user in the edit profile menu (inside account/view profile).")
  public void addingUserDescription() {
    String descriptionInput = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," + " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
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
    LOG.info("Verifying if correct pade loaded.");
    assertThat(accountPage.getTitle()).isEqualTo("Account – Greenfox test-automation-blog");
    LOG.info("Navigating to user page");
    accountPage.getViewProfileLink().click();
    LOG.info("Verifying if correct pade loaded.");
    assertThat(userPage.getTitle()).isEqualTo(firstName + " " + lastName + " | Greenfox test-automation-blog");
    LOG.info("Opening profile edit option.");
    userPage.getSettingsButton().click();
    userPage.getEditProfileMenuButton().click();
    LOG.info("Adding profile description.");
    userPage.getUserBioField().sendKeys(descriptionInput);
    wait.until(ExpectedConditions.visibilityOf(userPage.getUpdateProfileButton()));
    userPage.getUpdateProfileButton().submit();
    LOG.info("Checking if user description is displayed.");
    wait.until(ExpectedConditions.visibilityOf(userPage.getFrownIcon()));
    assertThat(userPage.getUserBio().isDisplayed()).isTrue();
    LOG.info("Checking if user description matches input data.");
    assertThat(userPage.getUserBio().getText()).isEqualTo(descriptionInput);
    Allure.addAttachment("Profile description added successfully.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    LOG.info("Adding profile description was successful.");
  }
}
