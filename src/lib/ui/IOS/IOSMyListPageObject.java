package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIstPageObject;

/**
 * Created by Mari on 10/22/18.
 */
public class IOSMyListPageObject extends MyLIstPageObject {
  static{
            ARTICLE_BY_TITLE_TPL ="xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]";



  }
  public IOSMyListPageObject(AppiumDriver driver){
    super(driver);
  }
}

