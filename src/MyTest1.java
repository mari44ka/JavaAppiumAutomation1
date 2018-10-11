/**
 * Created by Mari on 10/5/18.
 */


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

/**
 * Created by Mari on 9/20/18.
 */
public class MyTest1 {
  private AppiumDriver driver;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "AndroidTestDevice");
    capabilities.setCapability("platformVersion", "5.1");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "org.wikipedia");
    capabilities.setCapability("appActivity", ".main.MainActivity");
    capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/org.wikipedia.apk");
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @After
  public void tearDown() {
    driver.quit();

  }

  @Test
  public void testSearchAndAssertText() {
    waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find 'Search Wikipedia'",
            5);

    WebElement element = WaitforElementPresent(
            By.xpath("//*[contains(@text,'Search…')]"),
            "Cannot find 'Search...",
            5);

    String Search_test = element.getAttribute("text");

    Assert.assertEquals("we cannot find 'Search...'",
            "Search…",
            Search_test);

  }

  @Test
  public void testSearchCancel() {
    waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find 'Search Wikipedia'",
            5);

    waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Google",
            "cannot find search input",
            5);
    WaitforElementPresent(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Web browser developed by Google']"),
            "cannot find 'browser developed by Google'",
            5);
    waitforElementAndClear(By.id("org.wikipedia:id/search_src_text"),
            "cannot find search input search field",
            5);

    waitForElementPresentAndClick(By.id("org.wikipedia:id/search_close_btn"),
            "cannot find X to cancel search",
            5);

    waitForElementNotPresent(By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Web browser developed by Google']"),
            "Search result is still present",
            5);
  }

  @Test
  public void testSaveTwoArticles()
  {
    waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    waitForElementPresentAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']"),
            "cannot find Object-oriented programming language. Topic searching by java",
            5);
    WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);

    waitForElementPresentAndClick(By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
            "cannot find button to open article options",
            5);
    waitForElementPresentAndClick(By.xpath("//*[@text ='Add to reading list']"),
            "cannot find option 'add to reading list'",
            5);
    waitForElementPresentAndClick(By.id("org.wikipedia:id/onboarding_button"),
            "cannot find 'Got it' button",
            5);
    waitforElementAndClear(By.id("org.wikipedia:id/text_input"),
            "cannot find input to set name for article folder",
            5);

    String name_of_folder = "learning programming";

    waitForElementPresentAndSendKeys(By.id("org.wikipedia:id/text_input"),
            name_of_folder,
            "cannot put text into input",
            5);

    waitForElementPresentAndClick(By.xpath("//*[@text = 'OK']"),
            "cannot click button OK",
            5);
    waitForElementPresentAndClick(By.xpath("//android.widget.ImageButton[@content-desc ='Navigate up']"),
            "cannot find X link",
            5);
    waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "cannot find search input",
            5);
    waitForElementPresentAndClick(By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text = 'Java version history']"),
            "cannot find article Java version history",
            5);
    WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            10);
    waitForElementPresentAndClick(By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
            "cannot find button to open article options",
            5);

    waitForElementPresentAndClick(By.xpath("//*[@text ='Add to reading list']"),
            "cannot find option 'add to reading list'",
            5);
    waitForElementPresentAndClick(By.xpath("//*[@text ='"+name_of_folder+"']"),
            "cannot find folder"+ name_of_folder,
            5);
    waitForElementPresentAndClick(By.xpath("//android.widget.ImageButton[@content-desc ='Navigate up']"),
            "cannot find X link",
            5);
    waitForElementPresentAndClick(By.xpath("//android.widget.FrameLayout[@content-desc ='My lists']"),
            "cannot find navigation button to my list",
            5);
    waitForElementPresentAndClick(By.xpath("//*[@text ='learning programming']"),
            "cannot find my list",
            5);
    WaitforElementPresent(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot find saved article",
            5);

    swipeElementToLeft(By.xpath("//*[@text = 'Java (programming language)']"),
            "cannot swipe element");
    waitForElementPresentAndClick(By.xpath("//*[@text ='Java version history']"),
            "cannot find article left",5);

    WebElement title_element = WaitforElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "cannot find title",
            15);

    String article_title = title_element.getAttribute("text");

    String title ="Java version history";

    Assert.assertEquals(
            "we cannot see expected title"+ title,
            title,
            article_title);

  }

  @Test
  public void testCheckTitlePresent()
  {
    waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "cannot find search input",
            5);

    String value = "Appium";

    waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
            value,
            "cannot find search input",
            5);
    waitForElementPresentAndClick(
            By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_title'][@text ='Appium']"),
            "cannot find article searched"+value,
            5);
    assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
            "title is not present");


  }

  @Test
  // проверяем вначале состояние экрана и поворачиваем, его как нам надо
  public void testScreenOrientation(){
    ScreenOrientation orientation = driver.getOrientation();
    if (orientation == ScreenOrientation.PORTRAIT){
      driver.rotate(ScreenOrientation.LANDSCAPE);
      
    }
  }

  private WebElement WaitforElementPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement waitForElementPresentAndClick(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.click();
    return element;
  }

  private WebElement waitForElementPresentAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.sendKeys(value);
    return element;
  }

  private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

  }

  private WebElement waitforElementAndClear(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;
  }
  private void swipeElementToLeft(By by, String error_message) {
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


  private void assertElementPresent(By by, String error_message) {
    int amountOfElements = getAmountOfElements(by);
    if (amountOfElements < 0) {
      String default_message = " An element'" + by.toString() + "'supposed to be present";
      throw new AssertionError(default_message + " " + error_message);
    }

  }
}