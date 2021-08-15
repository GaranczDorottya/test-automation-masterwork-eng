package com.greenfoxacademy.masterwork.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlogPostPage {
  WebDriver driver;
  List<WebElement> comments;
  List<String> savedPost;
  List<String> allSavedPosts = new ArrayList<>();

  public BlogPostPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//*[@id=\"main\"]/header/div/nav/ol/li[4]/a/span")
  WebElement button2;

  @FindBy(id = "comment")
  WebElement commentField;

  @FindBy(id = "comment-submit")
  WebElement commentSubmitButton;

  @FindBy(className = "comment-content")
  WebElement commentContent;

  @FindBy(tagName = "h2")
  WebElement postTitle;

  @FindBy(className = "meta-author")
  WebElement postAuthor;

  @FindBy(className = "meta-date")
  WebElement postDate;

  @FindBy(className = "meta-cat")
  WebElement postCategory;

  @FindBy(css = "div.entry-content.clr")
  WebElement postContent;

  public List<String> getAllPostContent() {
    return allSavedPosts;
  }

  public WebElement getCommentContent() {
    return commentContent;
  }

  public WebElement getCommentSubmitButton() {
    return commentSubmitButton;
  }

  public WebElement getCommentField() {
    return commentField;
  }

  public WebElement getButton2() {
    return button2;
  }

  public WebElement getPostTitle() {
    return postTitle;
  }

  public WebElement getPostAuthor() {
    return postAuthor;
  }

  public WebElement getPostDate() {
    return postDate;
  }

  public WebElement getPostCategory() {
    return postCategory;
  }

  public WebElement getPostContent() {
    return postContent;
  }

  public WebElement getLastCommentText() {
    comments = driver.findElements(By.className("comment-container"));
    String postId = comments.get(comments.size() - 1).getAttribute("id");
    return driver.findElement(By.xpath("//*[@id=\"" + postId + "\"]/article/div/div[3]/div/p"));
  }

  public WebElement getLastCommentStatus() {
    comments = driver.findElements(By.className("comment-container"));
    String postId = comments.get(comments.size() - 1).getAttribute("id");
    return driver.findElement(By.xpath("//*[@id=\"" + postId + "\"]/article/div/div[3]/p"));
  }

  public String removeLineBreak(WebElement element) {
    StringBuilder temp = new StringBuilder(element.getText());
    temp.setCharAt(temp.indexOf("\n"), ' ');
    return temp.toString();
  }

  public List<String> savePost() {
    savedPost = new ArrayList<>();
    savedPost.addAll(getElementContent(getPostTitle()));
    savedPost.add(removeLineBreak(getPostAuthor()));
    savedPost.add(removeLineBreak(getPostDate()));
    savedPost.add(removeLineBreak(getPostCategory()));
    savedPost.addAll(getElementContent(getPostContent()));
    savedPost.add("");
    saveContentList();
    return savedPost;
  }

  public void saveContentList() {
    for (int i = 0; i < savedPost.size(); i++) {
      if (allSavedPosts.size() == savedPost.size()) {
        allSavedPosts.add(allSavedPosts.size(), savedPost.get(i));
      } else {
        allSavedPosts.add(savedPost.get(i));
      }
    }
  }

  public List<String> getElementContent(WebElement element) {
    String content = element.getText();
    List<String> contentList = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    List<WebElement> images = element.findElements(By.tagName("img"));
    List<WebElement> emojis;
    if (element.getTagName().equals("h2")) {
      emojis = element.findElements(By.cssSelector(element.getTagName() + " > img"));
    } else {
      emojis = element.findElements(By.cssSelector("p > img"));
    }

    if (content.isBlank()) {
      for (WebElement emoji : emojis) {
        temp.append(emoji.getAttribute("alt"));
      }
      contentList.add(temp.toString().replaceAll("️", ""));
      return contentList;
    }

    if (!content.contains("\n")) {
      contentList.add(content);
    } else {
      String[] lines = content.split("\n");
      contentList.addAll(Arrays.asList(lines));
    }
    if (images.size() != 0) {
      for (WebElement image : images) {
        temp.append(image.getAttribute("src"));
      }
      contentList.add(temp.toString());
    }
    return contentList;
  }
}
