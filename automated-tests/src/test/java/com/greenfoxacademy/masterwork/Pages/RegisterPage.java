package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
  WebDriver driver;

  public RegisterPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "user_login-46")
  WebElement usernameField;

  @FindBy(id = "first_name-46")
  WebElement firstNameField;

  @FindBy(id = "last_name-46")
  WebElement lastNameField;

  @FindBy(id = "user_email-46")
  WebElement emailField;

  @FindBy(id = "user_password-46")
  WebElement passwordField;

  @FindBy(id = "confirm_user_password-46")
  WebElement confirmPasswordField;

  @FindBy(className = "um-icon-android-checkbox-outline-blank")
  WebElement emptyPrivacyCheckbox;

  @FindBy(className = "um-icon-android-checkbox-outline")
  WebElement checkedPrivacyCheckbox;

  @FindBy(xpath = "//a[contains(text(),'Show Privacy Statement')]")
  WebElement privacyLink;

  @FindBy(id = "um-submit-btn")
  WebElement registerButton;

  @FindBy(className = "um-field-error")
  WebElement passwordErrorMessage;

  public WebElement getUsernameField() {
    return usernameField;
  }

  public WebElement getFirstNameField() {
    return firstNameField;
  }

  public WebElement getLastNameField() {
    return lastNameField;
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getConfirmPasswordField() {
    return confirmPasswordField;
  }

  public WebElement getEmptyPrivacyCheckbox() {
    return emptyPrivacyCheckbox;
  }

  public WebElement getCheckedPrivacyCheckbox() {
    return checkedPrivacyCheckbox;
  }

  public WebElement getPrivacyLink() {
    return privacyLink;
  }

  public WebElement getRegisterButton() {
    return registerButton;
  }

  public WebElement getPasswordErrorMessage() {
    return passwordErrorMessage;
  }

  public void register(String username, String firstName, String lastName, String email, String password) {
    getUsernameField().sendKeys(username);
    getFirstNameField().sendKeys(firstName);
    getLastNameField().sendKeys(lastName);
    getEmailField().sendKeys(email);
    getPasswordField().sendKeys(password);
    getConfirmPasswordField().sendKeys(password);
    getEmptyPrivacyCheckbox().click();
    getRegisterButton().submit();
  }

  public void toPreviousPage() {
    driver.navigate().back();
  }
}
