package com.greenfoxacademy.masterwork;

import static org.assertj.core.api.Assertions.*;

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

@Feature("Registration")
public class TC02_Registration_Success extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC02_Registration_Success.class);

  @Test
  @DisplayName("#TC02_REGISTRATION_02")
  @Description("Successful registration to Greenfox test-automation-blog with valid data.")
  public void successfulRegistration() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to register page.");
    homePage.getRegisterMenuButton().click();
    LOG.info("Attempting registration with given data.");
    registerPage.register(username, firstName, lastName, email, password);
    wait.until(ExpectedConditions.titleContains(firstName + " " + lastName));
    LOG.info("Checking if user got redirected to user page.");
    assertThat(userPage.getTitle()).isEqualTo(firstName + " " + lastName + " | Greenfox test-automation-blog");
    wait.until(ExpectedConditions.visibilityOf(userPage.getUsersName()));
    LOG.info("Checking if users name is displayed correctly.");
    assertThat(userPage.getUsersName().isDisplayed()).isTrue();
    assertThat(userPage.getUsersName().getText()).isEqualTo(firstName + " " + lastName);
    Allure.addAttachment("User page displayed after successful registration.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    LOG.info("Registration attempt successful.");
  }
}