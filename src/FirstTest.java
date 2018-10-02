import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
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
    WebElement element_to_init_search = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
    element_to_init_search.click();
    //System.out.println("First test run");

    WebElement element_to_enter_search_line = WaitforElementPresentbyXpath("//*[contains(@text,'Search…')]", "cannot find search input");
    element_to_enter_search_line.sendKeys("Java");

    WaitforElementPresentbyXpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='Object-oriented programming language']", "cannot find Object-oriented programming language. Topic searching by java", 15);


  }
  private WebElement WaitforElementPresentbyXpath(String xpath, String error_message, long timeoutInSeconds )
  {
    WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    By by = By.xpath(xpath);
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }
  private WebElement WaitforElementPresentbyXpath(String xpath, String error_message)
  {

    return WaitforElementPresentbyXpath(xpath,error_message,5);
  }

}
