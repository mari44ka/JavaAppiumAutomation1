package lib.ui;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Mari on 10/18/18.
 */
public class SearchPageObjectIOS extends MainPageObject {
  private static final String
          SEARCH_INIT_ELEMENT = "id:Search Wikipedia",
          SEARCH_INPUT ="xpath://XCUIElementTypeNavigationBar[@name='Wikipedia, scroll to top of Explore']",
          SEARCH_RESULT_BYSUBSTRING_TPL ="xpath://XCUIElementTypeLink[@name={SUBSTRING}]";


  public SearchPageObjectIOS(AppiumDriver driver) {
    super(driver);
  }
  public void initSearchInput() {
    this.waitforElementAndClick(SEARCH_INIT_ELEMENT,
            "cannot find and click search init element", 5);
    this.WaitforElementPresent(SEARCH_INIT_ELEMENT, "cannot find search input after clicking search init element", 5);
  }

  public void typeSearchLine(String search_line) {
    this.waitforElementAndSendKeys(SEARCH_INPUT, search_line, "cannot find and type into search input", 5);

  }
  private static String getResultSearchElement(String substring) {
    return SEARCH_RESULT_BYSUBSTRING_TPL.replace("{SUBSTRING}", substring);
  }

  public void clickByArticleWithSubstring(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.waitforElementAndClick(search_result_xpath,"cannot find and click search result with substring"+substring,10);
  }




}
