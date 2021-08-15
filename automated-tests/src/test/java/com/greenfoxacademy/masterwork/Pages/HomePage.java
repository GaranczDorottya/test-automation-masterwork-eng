package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomePage {
  WebDriver driver;
  WebDriverWait wait;
  List<WebElement> datesOnPage;
  List<WebElement> continueReadingButtons;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(this.driver, 5);
    PageFactory.initElements(this.driver, this);
  }

  @FindBy(id = "menu-item-45")
  WebElement registerMenuButton;

  @FindBy(id = "menu-item-44")
  WebElement loginMenuButton;

  @FindBy(css = ".alignright.older-posts")
  WebElement olderPostsButton;

  @FindBy(id = "menu-item-72")
  WebElement logoutMenuButton;

  @FindBy(id = "menu-item-85")
  WebElement accountMenuButton;

  public WebElement getRegisterMenuButton() {
    return registerMenuButton;
  }

  public WebElement getLoginMenuButton() {
    return loginMenuButton;
  }

  public WebElement getOlderPostsButton() {
    return olderPostsButton;
  }

  public WebElement getLogoutMenuButton() {
    return logoutMenuButton;
  }

  public WebElement getAccountMenuButton() {
    return accountMenuButton;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void open() {
    driver.get("http://test-automation-blog.greenfox.academy/");
    wait.until(ExpectedConditions.elementToBeClickable(registerMenuButton));
  }

  public Date getDateOfLastListedPost() throws ParseException {
    datesOnPage = driver.findElements(By.className("meta-date"));
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
    StringBuilder temp = new StringBuilder(datesOnPage.get(0).getText());
    temp.delete(0, temp.indexOf("\n") + 1);
    return dateFormat.parse(temp.toString());
  }

  public WebElement getContinueReadingButtonByIndex(String postIndex) {
    continueReadingButtons = driver.findElements(By.linkText("Continue Reading"));
    return continueReadingButtons.get(Integer.parseInt(postIndex));
  }

  public List<WebElement> getContinueReadingButtons() {
    return driver.findElements(By.linkText("Continue Reading"));
  }
}