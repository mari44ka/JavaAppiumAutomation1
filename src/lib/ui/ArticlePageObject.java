package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/12/18.
 */
abstract public class ArticlePageObject extends MainPageObject {

  protected static String
          TITLE,
          FOOTER_ELEMENT,
          OPTIONS_BUTTON ,
          OPTIONS_ADD_TO_MYLIST_BUTTON,
          ADD_TO_MYLIST_OVERLAY,
         MYLIST_NAME_INPUT,
         MYLIST_OK_BUTTON,
         CLOSE_ARTICLE_BUTTON,
         OPEN_ARTICLE_TPL,
         CLOSE_SYNC_OR_SAVED_ARTICLE_WINDOW;




  public ArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }


  public WebElement waitForTitleElement() {
    return this.WaitforElementPresent(TITLE, "cannot find article title on page", 15);
  }
   public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    if (Platform.getInstance().isAndroid()){
        return title_element.getAttribute("text");}
    else {
        return title_element.getAttribute("name");
    }

   }

   public void swipeToFooter(){
     if(Platform.getInstance().isAndroid()){
       this.swipeUpToFindElement(FOOTER_ELEMENT,"cannot find the end of article",40);}
       else{
       this.swipeUpTillElementAppear(FOOTER_ELEMENT,"cannot find the end of article",40);
     }

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

  public void addArticleToMySaved(){
    this.waitforElementAndClick(
            OPTIONS_ADD_TO_MYLIST_BUTTON,
            "cannot find option to add article to reading list",
            5);
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
  public void closeSyncSavedArticle(){
    this.waitforElementAndClick(CLOSE_SYNC_OR_SAVED_ARTICLE_WINDOW,
            "cannot find close or sync article window",
            5);
  }

}
