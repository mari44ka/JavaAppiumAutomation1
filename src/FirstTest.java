
import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Created by Mari on 9/20/18.
 */
public class FirstTest extends CoreTestCase {

  @Test
  public void testSearch() {
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);

    WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            15);

  }

  @Test
  public void testCancelSearch()

  {

    waitforElementAndClick(By.id("org.wikipedia:id/search_container"),
            "cannot find search input",
            5);

    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);

    waitForElementAndClear(By.id("org.wikipedia:id/search_src_text"),
            "cannot find search input search field",
            5);


    waitforElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
            "cannot find X to cancel search",
            5);


    waithForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"),
            "X is still present on the page",
            5);


  }

  @Test
  public void testCompareArticleTitle() {
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            5);

    WebElement title_element = WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
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
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Appium",
            "cannot find search input",
            5);
    waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_title'][@text ='Appium']"),
            "cannot find article Appium",
            5);
    WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);

    swipeUpToFindElement(
            By.xpath("//*[@text ='View page in browser']"),
            "Cannot find the end of the article",
            20);


  }

  @Test
  public void testsaveFirstArticleToMyList() {
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            5);
    WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);

    waitforElementAndClick(By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
            "cannot find button to open article options",
            5);
    waitforElementAndClick(By.xpath("//*[@text ='Add to reading list']"),
            "cannot find option 'add to reading list'",
            5);
    waitforElementAndClick(By.id("org.wikipedia:id/onboarding_button"),
            "cannot find 'Got it' button",
            5);
    waitForElementAndClear(By.id("org.wikipedia:id/text_input"),
            "cannot find input to set name for article folder",
            5);

   String name_of_folder = "learning programming";
    waitforElementAndSendKeys(By.id("org.wikipedia:id/text_input"),
            name_of_folder,
            "cannot put text into input",
            5);

    waitforElementAndClick(By.xpath("//*[@text = 'OK']"),
            "cannot click button OK",
            5);

    waitforElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc ='Navigate up']"),
            "cannot find X link",
            5);
    waitforElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc ='My lists']"),
            "cannot find navigation button to my list",
            5);
    waitforElementAndClick(By.xpath("//*[@text ='learning programming']"),
            "cannot find my list",
            5);
    WaitforElementPresent(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot find saved article",
            5);

    swipeElementToLeft(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot swipe element");

    waithForElementNotPresent(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot delete article",
            5);


  }

  @Test
  public void testAmountOfNotEmptySearch() {

    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Linkin park discography";
    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line",
            5);
    String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id ='org.wikipedia:id/page_list_item_container']";
    WaitforElementPresent(By.xpath(search_result_locator),
            "cannot find anyting by the request" + search_line,
            15);

    int amountOfSearchResults = getAmountOfElements(By.xpath(search_result_locator));
    Assert.assertTrue("we found too few results",
            amountOfSearchResults > 0);

  }

  @Test
  public void testAmountOfEmptySearch() {
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "fjsdljf";
    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line",
            5);
    String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id ='org.wikipedia:id/page_list_item_container']";
    String serch_empty_result_label = "//*[@text='No results found']";
    WaitforElementPresent(By.xpath(serch_empty_result_label),
            "cannot find label by the request" + search_line,
            5);
    assertElementNotPresent(By.xpath(search_result_locator),
            "we found some result by request" + search_line);


  }

  @Test

  public void testChangeScreenOrientationOnSearchResult()
  {
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Java";
    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line by request"+search_line,
            5);
    waitforElementAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            15);

    String title_before_rotation = waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
            "text",
            "cannot find title or article",
            15);
    driver.rotate(ScreenOrientation.LANDSCAPE);

    String title_after_rotation = waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
            "text",
            "cannot find title or article",
            15);
    driver.rotate(ScreenOrientation.PORTRAIT);
    String title_after_second_rotation = waitForElementAndGetAttribute(By.id("org.wikipedia:id/view_page_title_text"),
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
    waitforElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);
    String search_line = "Java";
    waitforElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "cannot find search line by request"+search_line,
            5);
    WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            15);

    driver.runAppInBackground(8);
    WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find article after returning from background",
            15);


  }


  private WebElement WaitforElementPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }


  private WebElement WaitforElementPresent(By by, String error_message) {
    return WaitforElementPresent(by, error_message, 5);
  }


  private WebElement waitforElementAndClick(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.click();
    return element;

  }

  private WebElement waitforElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.sendKeys(value);
    return element;

  }


  private boolean waithForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

  }

  private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;

  }

  protected void swipeUp(int timeOfSwipe) {
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * 0.8);
    int end_y = (int) (size.height * 0.2);
    action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();

  }

  protected void swipeUpQuick() {
    swipeUp(200);

  }

  protected void swipeUpToFindElement(By by, String error_message, int max_swipes) {
    driver.findElements(by);
    driver.findElements(by).size();
    int already_swiped = 0;
    while (driver.findElements(by).size() == 0) {
      if (already_swiped > max_swipes) {
        WaitforElementPresent(by, "Cannot find an element by swiping up\n" + error_message, 0);
        return;
      }
      ++already_swiped;
      swipeUpQuick();
    }
  }

  protected void swipeElementToLeft(By by, String error_message) {
    WebElement element = WaitforElementPresent(
            by,
            error_message,
            10);
    int left_x = element.getLocation().getX();

    int right_x = left_x + element.getSize().getWidth();
    int upper_y = element.getLocation().getY();
    int lower_y = upper_y + element.getSize().getHeight();
    int middle_y = (upper_y + lower_y) / 2;
    TouchAction action = new TouchAction(driver);
    action.
            press(right_x, middle_y).
            waitAction(300).
            moveTo(left_x, middle_y).
            release().
            perform();
  }

  private int getAmountOfElements(By by) {
    List elements = driver.findElements(by);
    return elements.size();

  }


  private void assertElementNotPresent(By by, String error_message) {
    int amountOfElements = getAmountOfElements(by);
    if (amountOfElements > 0) {
      String default_message = " An element'" + by.toString() + "'supposed to be not present";
      throw new AssertionError(default_message + " " + error_message);
    }

  }
  private String waitForElementAndGetAttribute(By by, String attribute,String error_message, long timeOutInSeconds)
  {
    WebElement element = WaitforElementPresent(by,error_message,timeOutInSeconds);
    return element.getAttribute(attribute);


  }
}














