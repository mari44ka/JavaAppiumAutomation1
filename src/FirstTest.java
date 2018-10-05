import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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



}
