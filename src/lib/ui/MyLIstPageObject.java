package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * Created by Mari on 10/12/18.
 */
abstract public class MyLIstPageObject extends MainPageObject {

  protected static String
          FOLDER_NAME_TPL,
          ARTICLE_BY_TITLE_TPL,
          REMOVE_FROM_SAVED_BUTTON;

  private static String getFolderXpathByName(String name_of_folder) {
    return FOLDER_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
  }

  private static String getTitleNameByXpath(String title_name) {
    return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", title_name);
  }

  private static String getRemoveButtonByTitle(String article_title) {
    return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}",article_title);
  }

  public MyLIstPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  public void openFolderByName(String name_of_folder) {
    String folder_name_xpath = getFolderXpathByName(name_of_folder);
    this.waitforElementAndClick(folder_name_xpath,
            "cannot find folder by name" + name_of_folder,
            5);

  }

  public void waitForArticleToAppearByTitle(String article_title) {
    String article_xpath = getTitleNameByXpath(article_title);
    this.WaitforElementPresent(article_xpath, "cannot find saved article by title " + article_title, 15);
  }

  public void waitForArticleToDesappearByTitle(String article_title) {
    String article_xpath = getTitleNameByXpath(article_title);
    this.waithForElementNotPresent(article_xpath, "saved article still present with title" + article_title, 15);
  }

  public void swipeArticleToDelete(String article_title) {
    this.waitForArticleToAppearByTitle(article_title);
    String article_xpath = getTitleNameByXpath(article_title);
    if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {

      this.swipeElementToLeft(article_xpath,
              "cannot swipe element");}
    else {
      String remove_locator = getRemoveButtonByTitle(article_title);
      this.waitforElementAndClick(remove_locator,
              "cannot click button to remove article from saved", 10);


      if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRightUpperCorner(article_xpath, "cannot fined saved article");
      }
      if (Platform.getInstance().isMW()){
        driver.navigate().refresh();
      }

      this.waitForArticleToDesappearByTitle(article_title);
    }
  }
}

