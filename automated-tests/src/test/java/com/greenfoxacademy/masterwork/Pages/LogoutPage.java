package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
  WebDriver driver;

  public LogoutPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(className = "wp-die-message")
  WebElement logoutMessage;

  @FindBy(tagName = "a")
  WebElement logoutLink;

  public WebElement getLogoutMessage() {
    return logoutMessage;
  }

  public WebElement getLogoutLink() {
    return logoutLink;
  }
}
