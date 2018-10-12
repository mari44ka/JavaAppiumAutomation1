package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Mari on 10/12/18.
 */
public class MyLIstPageObject extends MainPageObject {

  public static final String
  FOLDER_NAME_TPL = "//*[@text ='{FOLDER_NAME}']",
  ARTICLE_BY_TITLE_TPL = "//*[@text = '{TITLE}']";
  private static String getFolderXpathByName(String name_of_folder){
    return FOLDER_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
  }

  private  static String getTitleNameByXpath(String title_name){
    return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", title_name);
  }

  public MyLIstPageObject(AppiumDriver driver){
    super(driver);
  }

  public void openFolderByName(String name_of_folder){
    String folder_name_xpath =  getFolderXpathByName(name_of_folder);
    this.waitforElementAndClick(By.xpath(folder_name_xpath),
            "cannot find folder by name" + name_of_folder,
            5);

  }
  public void waitForArticleToAppearByTitle(String article_title){
    String article_xpath = getTitleNameByXpath(article_title);
    this.WaitforElementPresent(By.xpath(article_xpath),"cannot find saved article by title" + article_title,15);
  }

  public void waitForArticleToDesappearByTitle(String article_title){
    String article_xpath = getTitleNameByXpath(article_title);
    this.waithForElementNotPresent(By.xpath(article_xpath),"saved article still present with title" + article_title,15);
  }

  public void swipeArticleToDelete(String article_title){
    waitForArticleToAppearByTitle(article_title);
    String article_xpath = getTitleNameByXpath(article_title);
    this.swipeElementToLeft(By.xpath(article_xpath),
            "cannot swipe element");
    this.waitForArticleToDesappearByTitle(article_title);

  }
}
