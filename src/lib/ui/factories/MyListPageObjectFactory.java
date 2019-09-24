package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.Android.AndroidMyListPageObgect;
import lib.ui.ArticlePageObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.IOS.IOSMyListPageObject;
import lib.ui.MyLIstPageObject;
import lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/22/18.
 */
public class MyListPageObjectFactory {
  public static MyLIstPageObject get(RemoteWebDriver driver){
    if (Platform.getInstance().isAndroid()){
      return new AndroidMyListPageObgect(driver);
    }
    if (Platform.getInstance().isIOS()){
      return new IOSMyListPageObject(driver);
    }
    else{
      return new MWMyListsPageObject(driver);
    }
  }
}
