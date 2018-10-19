package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;

/**
 * Created by Mari on 10/18/18.
 */
public class ArticlePageObjectIOS extends MainPageObject {
  private static final String
          WAIT_WINDOW = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]",
          SAVE_FORLATER_BUTTON = "id:Save for later";

  public ArticlePageObjectIOS(AppiumDriver driver) {
    super(driver);
  }

  public void ArticlePresent(){
    this.WaitforElementPresent(WAIT_WINDOW,"cannot download article",5);

  }
  public void addArticleToMyList(String name_of_folder){
    this.waitforElementAndClick(
            SAVE_FORLATER_BUTTON,
            "cannot click on 'Save for later' button",
            5);

  }

}
