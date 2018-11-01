package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.ArticlePageObject;
import lib.ui.IOS.IOSArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/20/18.
 */
public class ArticlePageObjectFactory {

    public static ArticlePageObject get(RemoteWebDriver driver){
      if (Platform.getInstance().isAndroid()){
        return new AndroidArticlePageObject(driver);
      }
      else{
        return new IOSArticlePageObject(driver);
      }
    }
  }

