package com.greenfoxacademy.masterwork;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Data extracting")
public class TC14_Data_Saving extends BaseTest {
  Logger LOG = LoggerFactory.getLogger(TC14_Data_Saving.class);
  File TC14 = new File("./src/test/TC14_saved_blogposts.txt");

  @Test
  @DisplayName("#TC14_DATA_SAVING")
  @Description("Saving the title, author, issue date, category and content of every blog post on Greenfox test-automation-blog.")
  public void savingPageContentToTxtFile() throws IOException {
    LOG.info("Opening page...");
    homePage.open();
    LOG.info("Page successfully opened.");
    LOG.info("Saving all blog posts to text file.");
    saveAllPosts();
    LOG.info("Checking if file content matches blog content.");
    assertThat(Files.readAllLines(TC14.toPath())).isEqualTo(blogPostPage.getAllPostContent());
    LOG.info("Blog posts successfully saved.");
    addTxtFileToReport(TC14);
    LOG.info("Save file added to report.");
    TC14.delete();
    LOG.info("Text file has been deleted.");
  }

  public void saveAllPosts() throws IOException {
    int pageCounter = 1;
    for (int i = 0; i < pageCounter; i++) {
      for (int j = 0; j < homePage.getContinueReadingButtons().size(); j++) {
        homePage.getContinueReadingButtons().get(j).click();
        Files.write(TC14.toPath(), blogPostPage.savePost(),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND);
        driver.navigate().back();
      }
      if (homePage.getOlderPostsButton().isDisplayed()) {
        homePage.getOlderPostsButton().click();
        pageCounter++;
      }
    }
  }

  public void addTxtFileToReport(File file) throws IOException {
    Path content = file.toPath();
    try (InputStream is = Files.newInputStream(content)) {
      Allure.addAttachment("TC14_saved_blogposts", is);
    }
  }
}
