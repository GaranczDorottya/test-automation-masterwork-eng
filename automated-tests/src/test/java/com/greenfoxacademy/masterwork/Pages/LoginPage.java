package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "user_login")
  WebElement usernameField;

  @FindBy(id = "user_pass")
  WebElement passwordField;

  @FindBy(id = "wp-submit")
  WebElement logInButton;

  @FindBy(id = "login_error")
  WebElement loginError;

  public WebElement getUsernameField() {
    return usernameField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getLogInButton() {
    return logInButton;
  }

  public WebElement getLoginError() {
    return loginError;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void login(String username, String password) {
    getUsernameField().sendKeys(username);
    getPasswordField().sendKeys(password);
    getLogInButton().submit();
  }
}
