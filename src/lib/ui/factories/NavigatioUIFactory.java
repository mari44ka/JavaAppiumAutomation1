package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.Android.AndroidNavigationUI;
import lib.ui.ArticlePageObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.IOS.IOSNavigationUI;
import lib.ui.NavigationUI;

/**
 * Created by Mari on 10/22/18.
 */
public class NavigatioUIFactory {
  public static NavigationUI get(AppiumDriver driver){
    if (Platform.getInstance().isAndroid()){
      return new AndroidNavigationUI(driver) {
      };
    }
    else{
      return new IOSNavigationUI(driver);
    }
  }
}
