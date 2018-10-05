/**
 * Created by Mari on 10/5/18.
 */


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
public class MyTest1 {
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
  public void testSearchAndAssertText()
  {
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

  private  WebElement WaitforElementPresent(By by, String error_message,long timeoutInSeconds)
  {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement waitForElementPresentAndClick(By by,String error_message,long timeoutInSeconds)
  {
    WebElement element = WaitforElementPresent(by,error_message,timeoutInSeconds);
    element.click();
    return element;
  }

}
