package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/22/18.
 */
public class AndroidNavigationUI extends NavigationUI {
  static {
    MY_LISTS = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
  }
  public AndroidNavigationUI(RemoteWebDriver driver) {
    super(driver);
  }
}