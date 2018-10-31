package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

/**
 * Created by Mari on 10/20/18.
 */
public class IOSArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "id:Java (programming language)";
    FOOTER_ELEMENT = "id:View article in browser";
    OPTIONS_ADD_TO_MYLIST_BUTTON = "id:Save for later";
    CLOSE_ARTICLE_BUTTON = "id:Back";
    OPEN_ARTICLE_TPL =
            "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}']";
    CLOSE_SYNC_OR_SAVED_ARTICLE_WINDOW ="id:places auth close";
  }
  public IOSArticlePageObject (AppiumDriver driver){
    super(driver);
  }
}
