package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

/**
 * Created by Mari on 10/20/18.
 */
public class AndroidArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "id:org.wikipedia:id/view_page_title_text";
            FOOTER_ELEMENT = "xpath://*[@text ='View page in browser']";
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc = 'More options']";
            OPTIONS_ADD_TO_MYLIST_BUTTON = "xpath://*[@text ='Add to reading list']";
            ADD_TO_MYLIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
            MYLIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
            MYLIST_OK_BUTTON = "xpath://*[@text = 'OK']";
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc ='Navigate up']";
            OPEN_ARTICLE_TPL = "xpath://*[@text ='{SUBSTRING}']";
  }
  public AndroidArticlePageObject (AppiumDriver driver){
    super(driver);
  }
}