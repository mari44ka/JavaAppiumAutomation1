package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.Android.AndroidNavigationUI;
import lib.ui.ArticlePageObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.IOS.IOSNavigationUI;
import lib.ui.NavigationUI;
import lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/22/18.
 */
public class NavigatioUIFactory {
  public static NavigationUI get(RemoteWebDriver driver){
    if (Platform.getInstance().isAndroid()){
      return new AndroidNavigationUI(driver) {
      };
    }
    if (Platform.getInstance().isIOS()){
      return new IOSNavigationUI(driver);
    }
    else{
      return new MWNavigationUI(driver);
    }
  }

}
