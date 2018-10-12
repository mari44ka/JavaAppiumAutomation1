
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;


/**
 * Created by Mari on 9/20/18.
 */
public class FirstTest extends CoreTestCase {

  private MainPageObject MainPageObject;

  protected void setUp() throws Exception {
    super.setUp();
    MainPageObject = new MainPageObject(driver);
  }

  @Test
  public void testSearch() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);


    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");


  }

  @Test
  public void testCancelSearch()

  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);


    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForCanselButtonToAppear();
    SearchPageObject.clickCanselSearch();
    SearchPageObject.waitForCanselButtonToDisappear();

  }

  @Test
  public void testCompareArticleTitle() {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    MainPageObject.waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            5);

    WebElement title_element = MainPageObject.WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            15);

    String article_title = title_element.getAttribute("text");

    Assert.assertEquals(
            "we cannot see expected title",
            "Java (programming language)",
            article_title);


  }

  @Test

  public void testSwipeArticle() {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Appium",
            "cannot find search input",
            5);
    MainPageObject.waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_title'][@text ='Appium']"),
            "cannot find article Appium",
            5);
    MainPageObject.WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);

    MainPageObject.swipeUpToFindElement(
            By.xpath("//*[@text ='View page in browser']"),
            "Cannot find the end of the article",
            20);


  }

  @Test
  public void testsaveFirstArticleToMyList() {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    MainPageObject.waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            5);
    MainPageObject.WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);

    MainPageObject.waitforElementAndClick(By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
            "cannot find button to open article options",
            5);
    MainPageObject.waitforElementAndClick(By.xpath("//*[@text ='Add to reading list']"),
            "cannot find option 'add to reading list'",
            5);
    MainPageObject.waitforElementAndClick(By.id("org.wikipedia:id/onboarding_button"),
            "cannot find 'Got it' button",
            5);
    MainPageObject.waitForElementAndClear(By.id("org.wikipedia:id/text_input"),
            "cannot find input to set name for article folder",
            5);

   String name_of_folder = "learning programming";
    MainPageObject.waitforElementAndSendKeys(By.id("org.wikipedia:id/text_input"),
            name_of_folder,
            "cannot put text into input",
            5);

    MainPageObject.waitforElementAndClick(By.xpath("//*[@text = 'OK']"),
            "cannot click button OK",
            5);

    MainPageObject.waitforElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc ='Navigate up']"),
            "cannot find X link",
            5);
    MainPageObject.waitforElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc ='My lists']"),
            "cannot find navigation button to my list",
            5);
    MainPageObject.waitforElementAndClick(By.xpath("//*[@text ='learning programming']"),
            "cannot find my list",
            5);
    MainPageObject.WaitforElementPresent(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot find saved article",
            5);

    MainPageObject.swipeElementToLeft(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot swipe element");

    MainPageObject.waithForElementNotPresent(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot delete article",
            5);


  }

  @Test
  public void testAmountOfNotEmptySearch() {

    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Linkin park discography";
    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line",
            5);
    String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id ='org.wikipedia:id/page_list_item_container']";
    MainPageObject.WaitforElementPresent(By.xpath(search_result_locator),
            "cannot find anyting by the request" + search_line,
            15);

    int amountOfSearchResults = MainPageObject.getAmountOfElements(By.xpath(search_result_locator));
    Assert.assertTrue("we found too few results",
            amountOfSearchResults > 0);

  }

  @Test
  public void testAmountOfEmptySearch() {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "fjsdljf";
    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line",
            5);
    String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id ='org.wikipedia:id/page_list_item_container']";
    String serch_empty_result_label = "//*[@text='No results found']";
    MainPageObject.WaitforElementPresent(By.xpath(serch_empty_result_label),
            "cannot find label by the request" + search_line,
            5);
    MainPageObject.assertElementNotPresent(By.xpath(search_result_locator),
            "we found some result by request" + search_line);


  }

  @Test

  public void testChangeScreenOrientationOnSearchResult()
  {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Java";
    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line by request"+search_line,
            5);
    MainPageObject.waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            15);

    String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
            "text",
            "cannot find title or article",
            15);
    driver.rotate(ScreenOrientation.LANDSCAPE);

    String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
            "text",
            "cannot find title or article",
            15);
    driver.rotate(ScreenOrientation.PORTRAIT);
    String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
            "text",
            "cannot find title or article",
            15);


    Assert.assertEquals("Article title have benn changed after screen rotation",
            title_before_rotation,
            title_after_second_rotation);


  }

  @Test
  public void testCheckSearchArticleInBackground()
  {
    MainPageObject.waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Java";
    MainPageObject.waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line by request"+search_line,
            5);
    MainPageObject.WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            15);

    driver.runAppInBackground(8);
    MainPageObject.WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find article after returning from background",
            15);


  }



}














