package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/11/18.
 */
abstract public class SearchPageObject extends MainPageObject {

  protected static  String
          SEARCH_INIT_ELEMENT,
          SEARCH_INPUT,
          SEARCH_RESULT_BYSUBSTRING_TPL,
          SEARCH_CANSEL_BUTTON,
          SEARCH_RESULT_ELEMENT,
          SEARCH_EMPTY_RESULT_ELEMENT;


  public SearchPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  private static String getResultSearchElement(String substring) {
    return SEARCH_RESULT_BYSUBSTRING_TPL.replace("{SUBSTRING}", substring);
  }

  //templates methods
  public void initSearchInput() {
    this.waitforElementAndClick(SEARCH_INIT_ELEMENT,
            "cannot find and click search init element", 5);
    this.WaitforElementPresent(SEARCH_INIT_ELEMENT, "cannot find search input after clicking search init element", 5);
  }

  public void typeSearchLine(String search_line) {
    this.waitforElementAndSendKeys(SEARCH_INPUT, search_line, "cannot find and type into search input", 5);

  }

  public WebElement waitForSearchInput() {
    return this.WaitforElementPresent(SEARCH_INPUT, "cannot find search input", 5);

  }
  public String textAtribute(){
    WebElement element = waitForSearchInput();
    return element.getAttribute("text");
  }
  public void waitForSearchResult(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.WaitforElementPresent(search_result_xpath,"cannot find search result with substring"+substring);
  }
  public void waitForSearchResultNotPresent(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.waithForElementNotPresent(search_result_xpath,"search result with substring still present"+substring,5);
  }

  public void waitForCanselButtonToAppear(){
    this.WaitforElementPresent(SEARCH_CANSEL_BUTTON,"cannot find search cansel button",5);

  }
  public void waitForCanselButtonToDisappear() {
    this.WaitforElementPresent(SEARCH_CANSEL_BUTTON, "search cansel button is still present", 5);
  }
  public void clickCanselSearch() {
    this.waitforElementAndClick(SEARCH_CANSEL_BUTTON, "cannot find and click search cansel button", 5);
  }

  public void clickByArticleWithSubstring(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.waitforElementAndClick(search_result_xpath,"cannot find and click search result with substring"+substring,10);
  }

  public int getAmountOfFoundArticles(){
    this.WaitforElementPresent(SEARCH_RESULT_ELEMENT,
            "cannot find anyting by the request",
            15);
    return getAmountOfElements(SEARCH_RESULT_ELEMENT);
  }

  public void waitForEmptyResultsLabel(){
    this.WaitforElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,"cannot find empty result element",15);
  }

  public void assertThereIsNoResultOfSearch(){
    this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"we supposed not to find any result");
  }

  }
