package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Mari on 10/11/18.
 */
public class SearchPageObject extends MainPageObject {

  private static final String
          SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
          SEARCH_INPUT = "//*[contains(@text,'Search…')]",
          SEARCH_RESULT_BYSUBSTRING_TPL ="//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='{SUBSTRING}']",
          SEARCH_CANSEL_BUTTON = "org.wikipedia:id/search_close_btn";


  public SearchPageObject(AppiumDriver driver) {
    super(driver);
  }
  private static String getResultSearchElement(String substring){
    return SEARCH_RESULT_BYSUBSTRING_TPL.replace("{SUBSTRING}", substring);
  }
//templates methods
  public void initSearchInput(){
    this.waitforElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
            "cannot find and click search init element",5);
    this.WaitforElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"cannot find search input after clicking search init element",5);
  }

  public void typeSearchLine(String search_line){
    this.waitforElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line,"cannot find and type into search input",5);

  }

  public void waitForSearchResult(String substring){
    String search_result_xpath =getResultSearchElement(substring);
    this.WaitforElementPresent(By.xpath(search_result_xpath),"cannot find search result with substring"+substring);
  }

  public void waitForCanselButtonToAppear(){
    this.WaitforElementPresent(By.id(SEARCH_CANSEL_BUTTON),"cannot find search cansel button",5);

  }
  public void waitForCanselButtonToDisappear() {
    this.WaitforElementPresent(By.id(SEARCH_CANSEL_BUTTON), "search cansel button is still present", 5);
  }
  public void clickCanselSearch() {
    this.waitforElementAndClick(By.id(SEARCH_CANSEL_BUTTON), "cannot find and click search cansel button", 5);
  }

  }
