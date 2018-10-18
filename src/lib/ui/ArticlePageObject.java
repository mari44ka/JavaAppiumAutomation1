package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Mari on 10/12/18.
 */
public class ArticlePageObject extends MainPageObject {

  private static final String
          TITLE = "id:org.wikipedia:id/view_page_title_text",
          FOOTER_ELEMENT = "xpath://*[@text ='View page in browser']",
          OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc = 'More options']",
          OPTIONS_ADD_TO_MYLIST_BUTTON = "xpath://*[@text ='Add to reading list']",
          ADD_TO_MYLIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
         MYLIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
         MYLIST_OK_BUTTON = "xpath://*[@text = 'OK']",
         CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc ='Navigate up']",
         OPEN_ARTICLE_TPL = "xpath://*[@text ='{SUBSTRING}']";




  public ArticlePageObject(AppiumDriver driver) {
    super(driver);
  }


  public WebElement waitForTitleElement() {
    return this.WaitforElementPresent(TITLE, "cannot find article title on page", 15);
  }
   public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
   }

   public void swipeToFooter(){
     this.swipeUpToFindElement(FOOTER_ELEMENT,"cannot find the end of article",20);
   }

   public void addArticleToMyList(String name_of_folder){
     this.waitforElementAndClick(OPTIONS_BUTTON,
             "cannot find button to open article options",
             5);
     this.waitforElementAndClick(OPTIONS_ADD_TO_MYLIST_BUTTON,
             "cannot find option 'add to reading list'",
             5);
     this.waitforElementAndClick(ADD_TO_MYLIST_OVERLAY,
             "cannot find 'Got it' button",
             5);
     this.waitForElementAndClear(MYLIST_NAME_INPUT,
             "cannot find input to set name for article folder",
             5);

     this.waitforElementAndSendKeys(MYLIST_NAME_INPUT,
             name_of_folder,
             "cannot put text into input",
             5);

     this.waitforElementAndClick(MYLIST_OK_BUTTON,
             "cannot click button OK",
             5);

   }
  public void addanotherArticleToMyList(String name_of_folder){
    this.waitforElementAndClick(OPTIONS_BUTTON,
            "cannot find button to open article options",
            5);
    this.waitforElementAndClick(OPTIONS_ADD_TO_MYLIST_BUTTON,
            "cannot find option 'add to reading list'",
            5);
    this.waitforElementAndClick("//*[@text ='"+name_of_folder+"']",
            "cannot find folder"+ name_of_folder,
            10);


  }
  private static String getResultSearchElement(String substring) {
    return OPEN_ARTICLE_TPL.replace("{SUBSTRING}", substring);
  }


  public void openArticle(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.waitforElementAndClick(search_result_xpath,
            "cannot find article left",5);
  }


  public void closeArticle(){
     this.waitforElementAndClick(CLOSE_ARTICLE_BUTTON,
             "cannot find X link",
             5);
   }
  public void assertThereIsResultOfSearch(){
    this.assertElementPresent(TITLE,"cannot find title");
  }

}
