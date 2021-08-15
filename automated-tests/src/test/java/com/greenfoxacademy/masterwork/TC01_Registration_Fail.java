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
public class TC01_Registration_Fail extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC01_Registration_Fail.class);

  @Test
  @DisplayName("#TC01_REGISTRATION_01")
  @Description("Unsuccessful registration to Greenfox test-automation-blog with invalid password.")
  public void unsuccessfulRegistration() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to register page.");
    homePage.getRegisterMenuButton().click();
    LOG.info("Attempting registration with given data.");
    registerPage.register(username, firstName, lastName, email, invalidPassword);
    LOG.info("Attempt unsuccessful, waiting for error message to be displayed.");
    wait.until(ExpectedConditions.visibilityOf(registerPage.getPasswordErrorMessage()));
    Allure.addAttachment("Failed registration with invalid password.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    assertThat(registerPage.getPasswordErrorMessage().isDisplayed()).isTrue();
    LOG.info("Invalid password error message displayed.");
    assertThat(registerPage.getPasswordErrorMessage().getText()).isEqualTo("Your password must contain at least one lowercase letter, one capital letter and one number");
    LOG.info("Content of error message verified.");
    LOG.info("Registration unsuccessful.");
  }
}
