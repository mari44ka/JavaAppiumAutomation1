package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * Created by Mari on 10/12/18.
 */
abstract public class NavigationUI extends MainPageObject {

  protected static String
          MY_LISTS;

   public NavigationUI(RemoteWebDriver driver) {
    super(driver);
  }

  public void clickMyLists() {

    this.waitforElementAndClick(MY_LISTS,
            "cannot find navigation button to my list",
            5);
  }
}
