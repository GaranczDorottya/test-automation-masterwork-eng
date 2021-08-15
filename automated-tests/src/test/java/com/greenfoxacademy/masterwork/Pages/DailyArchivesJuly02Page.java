package com.greenfoxacademy.masterwork.Pages;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DailyArchivesJuly02Page {
  WebDriver driver;
  List<WebElement> postsOnPage;

  public DailyArchivesJuly02Page(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void checkPostsDate() {
    postsOnPage = driver.findElements(By.id("blog-entries"));
    WebElement issueDate = driver.findElement(By.className("meta-date"));
    for (int i = 0; i < postsOnPage.size(); i++) {
      assertThat(issueDate.getText()).contains("July 2, 2021");
    }
  }

  public List<WebElement> getPostsOnPage() {
    return postsOnPage;
  }

  public String getTitle() {
    return driver.getTitle();
  }
}
