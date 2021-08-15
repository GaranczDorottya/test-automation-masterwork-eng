package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserPage {
  WebDriver driver;

  public UserPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(className = "um-name")
  WebElement usersName;

  @FindBy(className = "um-faicon-cog")
  WebElement settingsButton;

  @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/div[2]/div[1]/div/div/ul/li[1]/a")
  WebElement editProfileMenuButton;

  @FindBy(id = "um-meta-bio")
  WebElement userBioField;

  @FindBy(xpath = "//*[@id=\"content\"]/article/div/div/div/form/div[5]/div[1]/div[1]/input")
  WebElement updateProfileButton;

  @FindBy(className = "um-meta-text")
  WebElement userBio;

  @FindBy(className = "um-faicon-frown-o")
  WebElement frownIcon;

  public WebElement getFrownIcon() {
    return frownIcon;
  }

  public WebElement getUserBio() {
    return userBio;
  }

  public WebElement getUpdateProfileButton() {
    return updateProfileButton;
  }

  public WebElement getUserBioField() {
    return userBioField;
  }

  public WebElement getSettingsButton() {
    return settingsButton;
  }

  public WebElement getEditProfileMenuButton() {
    return editProfileMenuButton;
  }

  public WebElement getUsersName() {
    return usersName;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public boolean isUserBioDisplayed() {
    List<WebElement> userBio = driver.findElements(By.className("um-meta-text"));
    return userBio.size() != 0;
  }
}