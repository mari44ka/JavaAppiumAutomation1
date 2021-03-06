package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidSearchPageObject;
import lib.ui.IOS.IOSSearchPageObject;
import lib.ui.SearchPageObject;
import lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/19/18.
 */
public class SearchPageObjectFactory {
  public static SearchPageObject get(RemoteWebDriver driver){
    if (Platform.getInstance().isAndroid()){
      return new AndroidSearchPageObject(driver);
    }
    if(Platform.getInstance().isIOS()){
      return new IOSSearchPageObject(driver);
    }
    else {
      return new MWSearchPageObject(driver);
    }
  }
}
