package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Mari on 10/12/18.
 */
public class NavigationUI extends MainPageObject {

  private static final String
          MY_LISTS = "//android.widget.FrameLayout[@content-desc ='My lists']";


   public NavigationUI(AppiumDriver driver) {
    super(driver);
  }

  public void clickMyLists() {

    this.waitforElementAndClick(By.xpath(MY_LISTS),
            "cannot find navigation button to my list",
            5);
  }
}
