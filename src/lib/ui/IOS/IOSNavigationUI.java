package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

/**
 * Created by Mari on 10/22/18.
 */
public class IOSNavigationUI extends NavigationUI {
  static {
    MY_LISTS = "id:Saved";
  }

  public IOSNavigationUI(AppiumDriver driver) {
    super(driver);
  }
}

