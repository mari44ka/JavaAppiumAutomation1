package lib.ui;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Mari on 10/12/18.
 */
public class ArticlePageObject extends MainPageObject {

  private static final String
          TITLE = "org.wikipedia:id/view_page_title_text",
          FOOTER_ELEMENT = "//*[@text ='View page in browser']",
  OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc = 'More options']",
  OPTIONS_ADD_TO_MYLIST_BUTTON = "//*[@text ='Add to reading list']",
  ADD_TO_MYLIST_OVERLAY = "org.wikipedia:id/onboarding_button",
  MYLIST_NAME_INPUT = "org.wikipedia:id/text_input",
  MYLIST_OK_BUTTON = "//*[@text = 'OK']",
  CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc ='Navigate up']";


  public ArticlePageObject(AppiumDriver driver) {
    super(driver);
  }


  public WebElement waitForTitleElement() {
    return this.WaitforElementPresent(By.id(TITLE), "cannot find article title on page", 15);
  }
   public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
   }

   public void swipeToFooter(){
     this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT),"cannot find the end of article",20);
   }

   public void addArticleToMyList(String name_of_folder){
     this.waitforElementAndClick(By.xpath(OPTIONS_BUTTON),
             "cannot find button to open article options",
             5);
     this.waitforElementAndClick(By.xpath(OPTIONS_ADD_TO_MYLIST_BUTTON),
             "cannot find option 'add to reading list'",
             5);
     this.waitforElementAndClick(By.id(ADD_TO_MYLIST_OVERLAY),
             "cannot find 'Got it' button",
             5);
     this.waitForElementAndClear(By.id(MYLIST_NAME_INPUT),
             "cannot find input to set name for article folder",
             5);

     this.waitforElementAndSendKeys(By.id(MYLIST_NAME_INPUT),
             name_of_folder,
             "cannot put text into input",
             5);

     this.waitforElementAndClick(By.xpath(MYLIST_OK_BUTTON),
             "cannot click button OK",
             5);

   }

   public void closeArticle(){
     this.waitforElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON),
             "cannot find X link",
             5);
   }
}
