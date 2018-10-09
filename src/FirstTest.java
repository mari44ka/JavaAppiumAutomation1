import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

/**
 * Created by Mari on 9/20/18.
 */
public class FirstTest {
  private AppiumDriver driver;

  @Before
  public void setUp() throws Exception
  {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "AndroidTestDevice");
    capabilities.setCapability("platformVersion", "5.1");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "org.wikipedia");
    capabilities.setCapability("appActivity", ".main.MainActivity");
    capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/org.wikipedia.apk");
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
  }
  @After
  public void tearDown()
  {
    driver.quit();

  }
  @Test
  public void firstTest()
  {
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


    waithForElementNotPresent(By.id( "org.wikipedia:id/search_close_btn"),
    "X is still present on the page",
            5);


  }

  @Test
  public void testCompareArticleTitle()
  {
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

  public void testSwipeArticle()
  {
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


  private WebElement WaitforElementPresent(By by, String error_message, long timeoutInSeconds )
  {
    WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }


  private WebElement WaitforElementPresent(By by, String error_message)
  {
    return WaitforElementPresent(by,error_message,5);
  }


  private WebElement waitforElementAndClick(By by, String error_message, long timeoutInSeconds)
  {
    WebElement element = WaitforElementPresent(by,error_message,timeoutInSeconds);
    element.click();
    return element;

  }

  private WebElement waitforElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
  {
    WebElement element =  WaitforElementPresent(by,error_message,timeoutInSeconds);
    element.sendKeys(value);
    return element;

  }



  private boolean waithForElementNotPresent(By by, String error_message, long timeoutInSeconds)
  {
    WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

  }

  private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
  {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;

  }

  protected void swipeUp(int timeOfSwipe)
  {
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x =size.width/2;
    int start_y = (int)(size.height * 0.8);
    int end_y =(int)(size.height*0.2);
    action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();

  }
  protected void swipeUpQuick()
  {
    swipeUp(200);

  }

  protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
  {
    driver.findElements(by);
    driver.findElements(by).size();
    int already_swiped = 0;
    while (driver.findElements(by).size()==0){
      if (already_swiped > max_swipes){
        WaitforElementPresent(by,"Cannot find an element by swiping up\n" + error_message,0);
        return;
      }
      ++already_swiped;
      swipeUpQuick();
    }

  }



}
