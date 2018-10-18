package lib.ui;

import io.appium.java_client.AppiumDriver;


/**
 * Created by Mari on 10/12/18.
 */
public class NavigationUI extends MainPageObject {

  private static final String
          MY_LISTS = "xpath://android.widget.FrameLayout[@content-desc ='My lists']";


   public NavigationUI(AppiumDriver driver) {
    super(driver);
  }

  public void clickMyLists() {

    this.waitforElementAndClick(MY_LISTS,
            "cannot find navigation button to my list",
            5);
  }
}
