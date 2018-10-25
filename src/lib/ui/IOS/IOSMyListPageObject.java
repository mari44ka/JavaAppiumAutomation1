package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIstPageObject;

/**
 * Created by Mari on 10/22/18.
 */
public class IOSMyListPageObject extends MyLIstPageObject {
  static{
            ARTICLE_BY_TITLE_TPL = "//XCUIElementTypeLink[@name='Java (programming language) Object-oriented programming language']";

  }
  public IOSMyListPageObject(AppiumDriver driver){
    super(driver);
  }
}

