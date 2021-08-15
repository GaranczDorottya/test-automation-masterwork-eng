package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SecondBlogPage {
  WebDriver driver;
  List<WebElement> postsOnPage;

  public SecondBlogPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(linkText = "Continue Reading")
  WebElement firstContinueReadingButton;

  public WebElement getContinueReadingButton() {
    return firstContinueReadingButton;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public Date getDateOfFirstListedPost() throws ParseException {
    postsOnPage = driver.findElements(By.id("blog-entries"));
    WebElement issueDate = driver.findElement(By.className("meta-date"));
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
    Date lastPostsDate = null;
    for (int i = 0; i < postsOnPage.size(); i++) {
      if (i == 0) {
        StringBuilder temp = new StringBuilder(issueDate.getText());
        temp.delete(0, temp.indexOf("\n") + 1);
        lastPostsDate = dateFormat.parse(temp.toString());
      }
    }
    return lastPostsDate;
  }
}
