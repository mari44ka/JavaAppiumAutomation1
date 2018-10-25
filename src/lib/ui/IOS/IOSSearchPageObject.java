package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

/**
 * Created by Mari on 10/19/18.
 */
public class IOSSearchPageObject extends SearchPageObject{
  static {
    SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
    SEARCH_INPUT = "xpath://XCUIElementTypeSearchField";
    SEARCH_RESULT_BYSUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
    SEARCH_CANSEL_BUTTON = "id:Close";
    SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
    SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
  }


  public IOSSearchPageObject(AppiumDriver driver){
    super(driver);
  }
}
