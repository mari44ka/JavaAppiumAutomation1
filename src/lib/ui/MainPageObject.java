package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Mari on 10/11/18.
 */
public class MainPageObject {
  protected AppiumDriver driver;

  public MainPageObject(AppiumDriver driver) {
    this.driver = driver;
  }

  public WebElement WaitforElementPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }


  public WebElement WaitforElementPresent(By by, String error_message) {
    return WaitforElementPresent(by, error_message, 5);
  }


  public WebElement waitforElementAndClick(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.click();
    return element;

  }

  public WebElement waitforElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.sendKeys(value);
    return element;

  }


  public boolean waithForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

  }

  public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;

  }

  public void swipeUp(int timeOfSwipe) {
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int) (size.height * 0.8);
    int end_y = (int) (size.height * 0.2);
    action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();

  }

  public void swipeUpQuick() {
    swipeUp(200);

  }

  public void swipeUpToFindElement(By by, String error_message, int max_swipes) {
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

  public void swipeElementToLeft(By by, String error_message) {
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

  public int getAmountOfElements(By by) {
    List elements = driver.findElements(by);
    return elements.size();

  }


  public void assertElementNotPresent(By by, String error_message) {
    int amountOfElements = getAmountOfElements(by);
    if (amountOfElements > 0) {
      String default_message = " An element'" + by.toString() + "'supposed to be not present";
      throw new AssertionError(default_message + " " + error_message);
    }

  }

  public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds) {
    WebElement element = WaitforElementPresent(by, error_message, timeOutInSeconds);
    return element.getAttribute(attribute);


  }

  public void assertElementPresent(By by, String error_message) {
    int amountOfElements = getAmountOfElements(by);
    if (amountOfElements < 0) {
      String default_message = " An element'" + by.toString() + "'supposed to be present";
      throw new AssertionError(default_message + " " + error_message);
    }

  }
}