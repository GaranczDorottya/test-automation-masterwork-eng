package com.greenfoxacademy.masterwork;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Login")
public class TC05_Login_Success extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC05_Login_Success.class);

  @Test
  @DisplayName("#TC05_LOGIN_02")
  @Description("Successful login to Greenfox test-automation-blog with valid data.")
  public void successfulLogin() {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Navigating to login page.");
    homePage.getLoginMenuButton().click();
    LOG.info("Attempting login with given data.");
    loginPage.login(username, password);
    wait.until(ExpectedConditions.titleContains("Hello, World!"));
    assertThat(homePage.getTitle()).isEqualTo("Greenfox test-automation-blog – Hello, World! \uD83D\uDC4B");
    assertThat(homePage.getLogoutMenuButton().isDisplayed()).isTrue();
    LOG.info("Login attempt successful.");
  }
}
