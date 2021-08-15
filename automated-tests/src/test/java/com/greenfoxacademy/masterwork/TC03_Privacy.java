package com.greenfoxacademy.masterwork;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Registration")
public class TC03_Privacy extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC03_Privacy.class);

  @Test
  @DisplayName("#TC03_PRIVACY")
  @Description("Opening Privacy Statements of Greenfox test-automation-blog then accepting them by checking the checkbox.")
  public void checkingAndAcceptingPrivacyStatements() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to register page.");
    homePage.getRegisterMenuButton().click();
    LOG.info("Opening Privacy Statement link.");
    registerPage.getPrivacyLink().click();
    privacyPage.getAcceptCookiesButton().click();
    LOG.info("Checking if link points toward another site.");
    assertThat(privacyPage.getTitle()).isNotEqualTo("Register – Greenfox test-automation-blog").isEqualTo("Google");
    LOG.info("Register page left successfully.");
    LOG.info("Navigating back to register page.");
    registerPage.toPreviousPage();
    LOG.info("Register page loaded.");
    LOG.info("Checking privacy statement checkbox.");
    registerPage.getEmptyPrivacyCheckbox().click();
    Allure.addAttachment("Checked Privacy Statement checkbox", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    LOG.info("Verifying if checkbox is checked.");
    assertThat(registerPage.getCheckedPrivacyCheckbox().isDisplayed()).isTrue();
    LOG.info("Privacy statements accepted.");
  }
}
